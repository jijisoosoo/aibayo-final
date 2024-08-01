package com.aico.aibayo.repository.teacher;

import com.aico.aibayo.dto.teacher.teacherDto;
import com.aico.aibayo.entity.*;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

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
    public List<teacherDto> findAllByKinderNo(Long kinderNo) {
        List<teacherDto> teachers = jpaQueryFactory
                .select(Projections.constructor(teacherDto.class,
                        member.id,
                        member.username,
                        member.name,
                        member.phone,
                        member.profilePicture,
                        acceptLog.acceptRegDate,
                        acceptLog.acceptNo))
                .from(member)
                .join(teacherKinder).on(member.id.eq(teacherKinder.teacherId))
                .join(acceptLog).on(teacherKinder.acceptNo.eq(acceptLog.acceptNo))
                .where(acceptLog.acceptStatus.eq(1),
                        teacherKinder.kinderNo.eq(1L))
                .fetch();

        System.out.println("repository : " + teachers.toString());
        return teachers;
    }
}
