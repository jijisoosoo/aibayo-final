package com.aico.aibayo.service;

import com.aico.aibayo.dto.NotepadDto;
import com.aico.aibayo.entity.NotepadEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NotepadService {
    List<NotepadEntity> getAllByKinderNo(Long kinderNo);
}
