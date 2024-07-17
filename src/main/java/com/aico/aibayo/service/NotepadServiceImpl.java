package com.aico.aibayo.service;

import com.aico.aibayo.dto.NotepadDto;
//import com.aico.aibayo.entity.QNotepadEntity;
import com.aico.aibayo.repository.NotepadReceiverRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class NotepadServiceImpl implements NotepadService {
    private final NotepadReceiverRepository notepadReceiverRepository;

    @Override
    public List<NotepadDto> getAllByKinderNo(int kinderNo) {
//        return notepadReceiverRepository.findAll();
//        QNotepadEntity qNotepad = new QNotepadEntity();

        return List.of();
    }
}
