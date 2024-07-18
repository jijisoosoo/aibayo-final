package com.aico.aibayo.service;

import com.aico.aibayo.dto.NotepadDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NotepadService {
    List<NotepadDto> getAllByKinderNo(int kinderNo);
}
