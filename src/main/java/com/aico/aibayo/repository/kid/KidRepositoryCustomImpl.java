package com.aico.aibayo.repository.kid;

import com.aico.aibayo.common.AcceptStatusEnum;
import com.aico.aibayo.common.BooleanEnum;
import com.aico.aibayo.dto.KidDto;
import com.aico.aibayo.entity.QAcceptLogEntity;
import com.aico.aibayo.entity.QClassEntity;
import com.aico.aibayo.entity.QClassKidEntity;
import com.aico.aibayo.entity.QClassTeacherEntity;
import com.aico.aibayo.entity.QKidEntity;
import com.aico.aibayo.entity.QMemberEntity;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class KidRepositoryCustomImpl implements KidRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    private final QKidEntity kid = QKidEntity.kidEntity;
    private final QClassKidEntity classKid = QClassKidEntity.classKidEntity;
    private final QAcceptLogEntity acceptLog1 = QAcceptLogEntity.acceptLogEntity;
    private final QClassEntity clazz = QClassEntity.classEntity;
    private final QClassTeacherEntity classTeacher = QClassTeacherEntity.classTeacherEntity;
    private final QMemberEntity member = QMemberEntity.memberEntity;
    private final QAcceptLogEntity acceptLog2 = QAcceptLogEntity.acceptLogEntity;

    @Override
    public List<KidDto> findAllByMemberId(Long id) {
        return jpaQueryFactory
                .select(Projections.constructor(KidDto.class,
                        kid.kidNo,
                        kid.kinderNo,
                        kid.kidName,
                        kid.kidBirth,
                        kid.kidGender,
                        kid.admissionDate,
                        kid.modifyDate,
                        kid.dischargeDate,
                        kid.dischargeFlag
                        ))
                .from(kid)
                .join(classKid).on(kid.kidNo.eq(classKid.kidNo))
                .join(acceptLog1).on(acceptLog1.acceptNo.eq(classKid.acceptNo))
                .join(clazz).on(clazz.classNo.eq(classKid.classNo))
                .join(classTeacher).on(clazz.classNo.eq(classTeacher.classNo))
                .join(member).on(
                        member.id.eq(classTeacher.classTeacherId),
                        member.kinderNo.eq(kid.kinderNo)
                ).join(acceptLog2).on(acceptLog2.acceptNo.eq(classTeacher.acceptNo))
                .where(
                        kid.dischargeFlag.eq(BooleanEnum.FALSE.getBool()),
                        acceptLog1.acceptStatus.eq(AcceptStatusEnum.ACCEPT.getStatus()),
                        acceptLog2.acceptStatus.eq(AcceptStatusEnum.ACCEPT.getStatus()),
                        member.id.eq(id)
                ).fetch();
    }
}
