package com.aico.aibayo.repository.returnHome;

import com.aico.aibayo.dto.announce.AnnounceDto;
import com.aico.aibayo.dto.returnHome.ReturnHomeDto;
import com.aico.aibayo.dto.returnHome.ReturnHomeSearchCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReturnHomeRepositoryCustom {
    Page<ReturnHomeDto>findAllByKinderNoCard(ReturnHomeSearchCondition condition, Pageable pageable);
    Page<ReturnHomeDto>findAllByKinderNoList(ReturnHomeSearchCondition condition, Pageable pageable);
    Page<ReturnHomeDto>findAllByKidNoCard(ReturnHomeSearchCondition condition, Pageable pageable);
    Page<ReturnHomeDto>findAllByKidNoList(ReturnHomeSearchCondition condition, Pageable pageable);

    ReturnHomeDto findByRhAgreeNo(Long rhAgreeNo);
}
