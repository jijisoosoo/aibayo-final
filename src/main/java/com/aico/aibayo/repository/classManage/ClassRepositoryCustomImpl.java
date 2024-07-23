package com.aico.aibayo.repository.classManage;

import com.aico.aibayo.common.AcceptStatusEnum;
import com.aico.aibayo.common.BooleanEnum;
import com.aico.aibayo.dto.ClassDto;
import com.aico.aibayo.entity.QAcceptLogEntity;
import com.aico.aibayo.entity.QClassEntity;
import com.aico.aibayo.entity.QClassTeacherEntity;
import com.aico.aibayo.entity.QMemberEntity;
import com.querydsl.core.types.Projections;
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
}
