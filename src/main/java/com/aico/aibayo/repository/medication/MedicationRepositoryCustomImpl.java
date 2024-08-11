package com.aico.aibayo.repository.medication;

import com.aico.aibayo.dto.Medication.MedicationDto;
import com.aico.aibayo.dto.Medication.MedicationSearchCondition;
import com.aico.aibayo.entity.*;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
public class MedicationRepositoryCustomImpl implements MedicationRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;
    private final QMemberEntity member =QMemberEntity.memberEntity;
    private final QAcceptLogEntity acceptLog=QAcceptLogEntity.acceptLogEntity;
    private final QMedicationDetailEntity medicationDetail=QMedicationDetailEntity.medicationDetailEntity;
    private final QOrderFormEntity orderForm=QOrderFormEntity.orderFormEntity;
    private final QMedicationOrderEntity medicationOrder=QMedicationOrderEntity.medicationOrderEntity;
    private final QMedicationPicEntity medicationPic=QMedicationPicEntity.medicationPicEntity;
    private final QMedicationReportEntity medicationReport=QMedicationReportEntity.medicationReportEntity;




    @Override
    public Page<MedicationDto> finAllByKinderNoList(MedicationSearchCondition condition, Pageable pageable) {
        return null;
    }

    @Override
    public Page<MedicationDto> findAllByKinderNoCard(MedicationSearchCondition condition, Pageable pageable) {
        return null;
    }

    @Override
    public MedicationDto findByAnnounceNo(Long orderNo) {
        return null;
    }
}
