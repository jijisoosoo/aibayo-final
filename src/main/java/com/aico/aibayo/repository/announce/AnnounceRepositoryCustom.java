package com.aico.aibayo.repository.announce;

import com.aico.aibayo.dto.announce.AnnounceDto;

public interface AnnounceRepositoryCustom {

    AnnounceDto findByAnnounceNo(Long announceNo);
}
