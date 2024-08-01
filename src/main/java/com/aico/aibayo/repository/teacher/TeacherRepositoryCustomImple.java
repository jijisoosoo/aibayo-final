package com.aico.aibayo.repository.teacher;

import com.aico.aibayo.common.AcceptStatusEnum;
import com.aico.aibayo.common.AcceptTypeEnum;
import com.aico.aibayo.dto.member.MemberDto;
import com.aico.aibayo.dto.teacher.TeacherSearchCondition;
import com.aico.aibayo.dto.teacher.teacherDto;
import com.aico.aibayo.entity.*;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class TeacherRepositoryCustomImple implements TeacherRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;

    private final QMemberEntity member = QMemberEntity.memberEntity;
    private final QClassEntity classEntity = QClassEntity.classEntity;
    private final QTeacherKinderEntity teacherKinder = QTeacherKinderEntity.teacherKinderEntity;
    private final QClassTeacherEntity classTeacher = QClassTeacherEntity.classTeacherEntity;
    private final QInviteCodeEntity inviteCode = QInviteCodeEntity.inviteCodeEntity;
    private final QAcceptLogEntity acceptLog = QAcceptLogEntity.acceptLogEntity;


    @Override
    public List<MemberDto> findAllByKinderNo(Long kinderNo) {
        List<MemberDto> fetch = jpaQueryFactory
                .select(Projections.constructor(MemberDto.class,
                        member.id,
                        member.username,
                        member.name,
                        member.password,
                        member.phone,
                        member.roleNo,
                        member.status,
                        member.regDate,
                        member.modifyDate,
                        member.inactivateDate,
                        member.latestLogDate,
                        member.profilePicture,
                        member.kinderNo
//                        member.profilePicture,
//                        acceptLog.acceptRegDate,
//                        acceptLog.acceptNo
                ))
                .from(member)
                .join(teacherKinder).on(member.id.eq(teacherKinder.teacherId))
                .join(acceptLog).on(teacherKinder.acceptNo.eq(acceptLog.acceptNo))
                .where(
                        acceptLog.acceptStatus.eq(AcceptStatusEnum.ACCEPT.getStatus()),
                        teacherKinder.kinderNo.eq(kinderNo)
                )
                .fetch();
        System.out.println(" fetch : " + fetch);
        System.out.println(" fetch : " + fetch.size());

        fetch.stream().map(t ->
                        MemberDto.toDto(t))
                .collect(Collectors.toList());

        return fetch;
    }

//    @Override
//    public List<teacherDto> findAllByKinderNo(TeacherSearchCondition condition, Long kinderNo) {
//        List<teacherDto> teachers = jpaQueryFactory
//                .select(Projections.constructor(teacherDto.class,
//                        member.id,
//                        member.username,
//                        member.name,
//                        member.phone,
//                        member.profilePicture,
//                        acceptLog.acceptRegDate,
//                        classTeacher.classNo,
//                        classTeacher.acceptNo,
//                        teacherKinder.acceptNo))
//                .from(member)
//                .join(teacherKinder).on(member.id.eq(teacherKinder.teacherId))
//                .join(acceptLog).on(teacherKinder.acceptNo.eq(acceptLog.acceptNo))
//                .join(classTeacher).on(member.id.eq(classTeacher.classTeacherId))
//                .join(acceptLog).on(classTeacher.acceptNo.eq(acceptLog.acceptNo))
//                .where(teacherKinder.acceptNo.eq(1l),
//                        classTeacher.acceptNo.eq(1l),
//                        teacherKinder.kinderNo.eq(1l)
//                        getClassNoEq(condition.getClass())
//                )
//                .fetch();
//        return List.of();
//    }

//
//    private BooleanExpression getClassNoEq(Long classNo) {
//        return classNo == null ? null : classTeacher.classNo.eq(classNo);
//    }
}





//List<MemberDto> fetch = jpaQueryFactory
//                .select(Projections.constructor(MemberDto.class,
//                        member.id,
//                        member.username,
//                        member.name,
//                        member.password,
//                        member.phone,
//                        member.roleNo,
//                        member.status,
//                        member.regDate,
//                        member.modifyDate,
//                        member.inactivateDate,
//                        member.latestLogDate,
//                        member.profilePicture,
//                        member.kinderNo
////                        member.profilePicture,
////                        acceptLog.acceptRegDate,
////                        acceptLog.acceptNo
//                ))
//                .from(member)
//                .join(teacherKinder).on(member.id.eq(teacherKinder.teacherId))
//                .join(acceptLog).on(teacherKinder.acceptNo.eq(acceptLog.acceptNo))
//                .where(
//                        acceptLog.acceptStatus.eq(AcceptStatusEnum.ACCEPT.getStatus()),
//                        teacherKinder.kinderNo.eq(kinderNo)
//                )
//                .fetch();
//        System.out.println(" fetch : " + fetch);
//        System.out.println(" fetch : " + fetch.size());