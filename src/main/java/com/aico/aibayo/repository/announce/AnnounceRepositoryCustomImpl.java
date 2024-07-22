package com.aico.aibayo.repository.announce;

import com.aico.aibayo.dto.announce.AnnounceDto;
import com.aico.aibayo.service.announce.AnnounceService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AnnounceRepositoryCustomImpl implements AnnounceService {


    @Override
    public AnnounceDto getByAnnounceNo(Long announceNo) {
        return null;
    }
}
