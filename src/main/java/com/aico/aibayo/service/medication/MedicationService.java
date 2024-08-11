package com.aico.aibayo.service.medication;

import com.aico.aibayo.dto.Medication.MedicationDto;
import com.aico.aibayo.dto.Medication.MedicationSearchCondition;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.HashMap;
@Service
public interface MedicationService {
    Page<MedicationDto> findAllByKinderNoList(MedicationSearchCondition condition, HashMap<String, Object> hashMap);
    Page<MedicationDto>findAllByKinderNoCard(MedicationSearchCondition condition, HashMap<String, Object> hashMap);
    MedicationDto findByAnnounceNo(Long orderNo);
}
