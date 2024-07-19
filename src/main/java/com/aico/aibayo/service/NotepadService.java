package com.aico.aibayo.service;

import com.aico.aibayo.dto.NotepadDto;
import com.aico.aibayo.entity.NotepadEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NotepadService {
    Page<NotepadDto> getAllByKinderNo(Long kinderNo, int page);
}
