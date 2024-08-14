package com.aico.aibayo.service.returnHome;

import com.aico.aibayo.dto.returnHome.ReturnHomeDto;
import com.aico.aibayo.dto.returnHome.ReturnHomeSearchCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface ReturnHomeService {
    Page<ReturnHomeDto> findAllByKinderNoCard(ReturnHomeSearchCondition condition, HashMap<String, Object> hashMap);
    Page<ReturnHomeDto> findAllByKinderNoList(ReturnHomeSearchCondition condition, HashMap<String, Object> hashMap);
    Page<ReturnHomeDto>findAllByKidNoCard(ReturnHomeSearchCondition condition, HashMap<String, Object> hashMap);
    Page<ReturnHomeDto>findAllByKidNoList(ReturnHomeSearchCondition condition, HashMap<String, Object> hashMap);
    ReturnHomeDto findByRhAgreeNo(Long rhAgreeNo);
}
