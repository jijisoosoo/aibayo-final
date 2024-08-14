package com.aico.aibayo.service.returnHome;

import com.aico.aibayo.dto.returnHome.ReturnHomeDto;
import com.aico.aibayo.dto.returnHome.ReturnHomeSearchCondition;
import com.aico.aibayo.repository.OrderFormRepository;
import com.aico.aibayo.repository.returnHome.ReturnHomeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReturnHomeServiceImpl implements ReturnHomeService{
    private final OrderFormRepository orderFormRepository;
    private final ReturnHomeRepository returnHomeRepository;
    private static final int PAGE_SIZE_CARD = 6;
    private static final int PAGE_SIZE_LIST = 15;

    @Override
    public Page<ReturnHomeDto> findAllByKinderNoCard(ReturnHomeSearchCondition condition, HashMap<String, Object> hashMap) {
        int page = (int) hashMap.get("page");
        String type = (String) hashMap.get("type");
        Pageable pageable = PageRequest.of(page - 1, PAGE_SIZE_CARD);
        return returnHomeRepository.findAllByKinderNoCard(condition,pageable);
    }

    @Override
    public Page<ReturnHomeDto> findAllByKinderNoList(ReturnHomeSearchCondition condition, HashMap<String, Object> hashMap) {
        return null;
    }

    @Override
    public Page<ReturnHomeDto> findAllByKidNoCard(ReturnHomeSearchCondition condition, HashMap<String, Object> hashMap) {
        int page = (int) hashMap.get("page");
        String type = (String) hashMap.get("type");
        Pageable pageable = PageRequest.of(page - 1, PAGE_SIZE_CARD);
        return returnHomeRepository.findAllByKidNoCard(condition,pageable);

    }

    @Override
    public Page<ReturnHomeDto> findAllByKidNoList(ReturnHomeSearchCondition condition, HashMap<String, Object> hashMap) {
        return null;
    }


    @Override
    public ReturnHomeDto findByRhAgreeNo(Long rhAgreeNo) {
        return returnHomeRepository.findByRhAgreeNo(rhAgreeNo);
    }
}
