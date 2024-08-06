package com.aico.aibayo.repository.classManage;

import com.aico.aibayo.common.AcceptStatusEnum;
import com.aico.aibayo.common.BooleanEnum;
import com.aico.aibayo.dto.ClassDto;
import com.aico.aibayo.entity.QAcceptLogEntity;
import com.aico.aibayo.entity.QClassEntity;
import com.aico.aibayo.entity.QClassKidEntity;
import com.aico.aibayo.entity.QClassTeacherEntity;
import com.aico.aibayo.entity.QMemberEntity;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClassRepositoryCustomImpl implements ClassRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;

    private final QClassEntity clazz = QClassEntity.classEntity;
    private final QClassTeacherEntity classTeacher = QClassTeacherEntity.classTeacherEntity;
    private final QAcceptLogEntity acceptLog = QAcceptLogEntity.acceptLogEntity;
    private final QMemberEntity member = QMemberEntity.memberEntity;
    private final QClassKidEntity classKid = QClassKidEntity.classKidEntity;

    @Override
    public List<ClassDto> findAllByMemberId(Long id) {
        return jpaQueryFactory
                .select(Projections.constructor(ClassDto.class,
                        clazz.classNo,
                        clazz.className,
                        clazz.classAge,
                        clazz.kinderNo,
                        clazz.classRegDate,
                        clazz.classModifyDate,
                        clazz.classDeleteDate,
                        clazz.classDeleteFlag
                        ))
                .from(clazz)
                .join(classTeacher).on(clazz.classNo.eq(classTeacher.classNo))
                .join(acceptLog).on(acceptLog.acceptNo.eq(classTeacher.acceptNo))
                .join(member).on(
                        member.id.eq(classTeacher.classTeacherId),
                        member.kinderNo.eq(clazz.kinderNo)
                ).where(
                        clazz.classDeleteFlag.eq(BooleanEnum.FALSE.getBool()),
                        acceptLog.acceptStatus.eq(AcceptStatusEnum.ACCEPT.getStatus()),
                        member.id.eq(id)
                ).fetch();
    }

    @Override
    public List<ClassDto> findAllByKidNo(Long kidNo) {
        return jpaQueryFactory
                .select(Projections.constructor(ClassDto.class,
                        clazz.classNo,
                        clazz.className,
                        clazz.classAge,
                        clazz.kinderNo,
                        clazz.classRegDate,
                        clazz.classModifyDate,
                        clazz.classDeleteDate,
                        clazz.classDeleteFlag,
                        acceptLog.acceptNo
                        ))
                .from(clazz)
                .join(classKid).on(clazz.classNo.eq(classKid.classNo))
                .join(acceptLog).on(acceptLog.acceptNo.eq(classKid.acceptNo))
                .where(
                        clazz.classDeleteFlag.eq(BooleanEnum.FALSE.getBool()),
                        acceptLog.acceptStatus.eq(AcceptStatusEnum.ACCEPT.getStatus()),
                        classKid.kidNo.eq(kidNo)
                )
                .fetch();
    }

    @Override
    public List<ClassDto> findClassByTeacherId(Long id) {
        List<ClassDto> classes = jpaQueryFactory
                .select(Projections.constructor(ClassDto.class,
                        clazz.classNo,
                        clazz.className,
                        clazz.classAge,
                        clazz.kinderNo,
                        clazz.classRegDate,
                        clazz.classModifyDate,
                        clazz.classDeleteDate,
                        clazz.classDeleteFlag))
                .from(clazz)
                .join(classTeacher).on(clazz.classNo.eq(classTeacher.classNo))
                .join(acceptLog).on(classTeacher.acceptNo.eq(acceptLog.acceptNo))
                .where(acceptLog.acceptStatus.eq(AcceptStatusEnum.ACCEPT.getStatus()),
                        classTeacher.classTeacherId.eq(id))
                .fetch();

        return classes;
    }

    @Override
    public List<ClassDto> findAddableClassByTeacherId(Long id, Long kinderNo, List<ClassDto> assignedClasses) {

        List<ClassDto> classes = jpaQueryFactory
                .select(Projections.constructor(ClassDto.class,
                        clazz.classNo,
                        clazz.className,
                        classTeacher.classTeacherId.count().as("assignedCnt")
                        ))
                .from(clazz)
                .join(classTeacher).on(clazz.classNo.eq(classTeacher.classNo))
                .join(acceptLog).on(classTeacher.acceptNo.eq(acceptLog.acceptNo))
                .where(clazz.classNo.notIn(
                        JPAExpressions.select(clazz.classNo)
                                .from(clazz)
                                .join(classTeacher).on(clazz.classNo.eq(classTeacher.classNo))
                                .join(acceptLog).on(classTeacher.acceptNo.eq(acceptLog.acceptNo))
                                .where(acceptLog.acceptStatus.eq(AcceptStatusEnum.ACCEPT.getStatus()),
                                        classTeacher.classTeacherId.eq(id))),
                        clazz.kinderNo.eq(kinderNo))
                .groupBy(clazz.classNo,
                        clazz.className
                        )
                .having(classTeacher.classTeacherId.count().lt(3L))
                .fetch();

        return classes;
    }


}
