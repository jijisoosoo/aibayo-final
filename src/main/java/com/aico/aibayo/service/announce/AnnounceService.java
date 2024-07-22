package com.aico.aibayo.service.announce;

import com.aico.aibayo.dto.announce.AnnounceDto;
import org.springframework.stereotype.Service;

@Service
public interface AnnounceService {
    AnnounceDto getByAnnounceNo(Long announceNo);


}
