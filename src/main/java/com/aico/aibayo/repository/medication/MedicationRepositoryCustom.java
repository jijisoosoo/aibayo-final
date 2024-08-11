package com.aico.aibayo.repository.medication;

import com.aico.aibayo.dto.Medication.MedicationDto;
import com.aico.aibayo.dto.Medication.MedicationSearchCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MedicationRepositoryCustom {
    Page<MedicationDto> finAllByKinderNoList(MedicationSearchCondition condition, Pageable pageable);
    Page<MedicationDto> findAllByKinderNoCard(MedicationSearchCondition condition, Pageable pageable);
    MedicationDto findByAnnounceNo (Long orderNo);

}
