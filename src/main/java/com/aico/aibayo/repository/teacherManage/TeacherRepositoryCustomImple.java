package com.aico.aibayo.repository.teacherManage;

import com.aico.aibayo.entity.*;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TeacherRepositoryCustomImple implements TeacherRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;

    private final QMemberEntity member = QMemberEntity.memberEntity;
    private final QClassEntity classEntity = QClassEntity.classEntity;
    private final QTeacherKinderEntity teacherKinder = QTeacherKinderEntity.teacherKinderEntity;
    private final QClassTeacherEntity classTeacher = QClassTeacherEntity.classTeacherEntity;
    private final QInviteCodeEntity inviteCode = QInviteCodeEntity.inviteCodeEntity;
    private final QAcceptLogEntity acceptLog = QAcceptLogEntity.acceptLogEntity;





}
