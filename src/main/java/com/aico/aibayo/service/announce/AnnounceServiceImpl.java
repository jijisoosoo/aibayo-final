package com.aico.aibayo.service.announce;


import com.aico.aibayo.dto.announce.AnnounceDto;
import com.aico.aibayo.dto.announce.AnnounceSearchCondition;
import com.aico.aibayo.dto.notepad.NotepadSearchCondition;
import com.aico.aibayo.repository.announce.AnnounceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor

public class AnnounceServiceImpl implements AnnounceService {
    private final AnnounceRepository announceRepository;
    private static final int PAGE_SIZE_CARD = 6;
    private static final int PAGE_SIZE_LIST = 15;
    private static final int PAGE_SIZE_PRIMARY = 5;

    @Override
    public Page<AnnounceDto> findAllByKinderNoList(AnnounceSearchCondition condition, HashMap<String, Object>hashMap) {
        int page = (int) hashMap.get("page");
        String type = (String) hashMap.get("type");
        int pagesize=0;
        if(type.equals("card")){
            pagesize=PAGE_SIZE_CARD;
        }else if(type.equals("list")){
            pagesize=PAGE_SIZE_LIST;
        }else if(type.equals("listPrimary")) {
            pagesize = PAGE_SIZE_PRIMARY;
        }


        Pageable pageable = PageRequest.of(page - 1, pagesize);
        return announceRepository.findAllByKinderNoList(condition,pageable);
    }

    @Override
    public Page<AnnounceDto> findAllByKinderNoCard(AnnounceSearchCondition condition, HashMap<String, Object> hashMap) {
        int page = (int) hashMap.get("page");
        String type = (String) hashMap.get("type");
        int pagesize=0;
        if(type.equals("card")){
            pagesize=PAGE_SIZE_CARD;
        }else if(type.equals("list")){
            pagesize=PAGE_SIZE_LIST;
        }
        Pageable pageable = PageRequest.of(page - 1, pagesize);
        return announceRepository.findAllByKinderNoCard(condition,pageable);
    }
    @Override
    public AnnounceDto findByAnnounceNo(Long announceNo) {
        return announceRepository.findByAnnounceNo(announceNo);
    }
}
