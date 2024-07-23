package com.aico.aibayo.service.announce;

import com.aico.aibayo.dto.announce.AnnounceDto;
import com.aico.aibayo.dto.announce.AnnounceSearchCondition;
import com.aico.aibayo.dto.notepad.NotepadSearchCondition;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface AnnounceService {
    Page<AnnounceDto>findAllByKinderNo(AnnounceSearchCondition condition, HashMap<String, Object> hashMap);
    AnnounceDto findByAnnounceNo(Long announceNo);


}
