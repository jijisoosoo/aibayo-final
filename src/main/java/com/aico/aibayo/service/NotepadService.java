package com.aico.aibayo.service;

import com.aico.aibayo.dto.NotepadDto;
import com.aico.aibayo.dto.NotepadSearchCondition;
import com.aico.aibayo.entity.NotepadEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NotepadService {
    Page<NotepadDto> getAllByKinderNo(NotepadSearchCondition condition, int page);
    Page<NotepadDto> getAllByKidNo(NotepadSearchCondition condition, int page);
}
