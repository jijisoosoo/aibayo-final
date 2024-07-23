package com.aico.aibayo.repository.announce;

import com.aico.aibayo.dto.announce.AnnounceDto;
import com.aico.aibayo.dto.announce.AnnounceSearchCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AnnounceRepositoryCustom {

    AnnounceDto findByAnnounceNo(Long announceNo);

    Page<AnnounceDto> findAllByKinderNo(AnnounceSearchCondition condition, Pageable pageable);
}
