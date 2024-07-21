package com.aico.aibayo.service;

import com.aico.aibayo.dto.NotepadDto;
//import com.aico.aibayo.entity.QNotepadEntity;
import com.aico.aibayo.dto.NotepadSearchCondition;
import com.aico.aibayo.repository.NotepadRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotepadServiceImpl implements NotepadService {
    private final NotepadRepository notepadRepository;
    private static final int PAGE_SIZE = 6;

    @Override
    public Page<NotepadDto> getAllByKinderNo(NotepadSearchCondition condition) {
        Pageable pageable = PageRequest.of(0, PAGE_SIZE);

        return getNotepadDtosByKinderNo(condition, pageable);
    }

    @Override
    public Page<NotepadDto> getAllByKinderNo(NotepadSearchCondition condition, int page) {
        Pageable pageable = PageRequest.of(page - 1, PAGE_SIZE);

        return getNotepadDtosByKinderNo(condition, pageable);
    }

    @Override
    public Page<NotepadDto> getAllByKidNo(NotepadSearchCondition condition, int page) {
        Pageable pageable = PageRequest.of(page - 1, PAGE_SIZE);

        return getNotepadDtosByKidNo(condition, pageable);
    }

    private Page<NotepadDto> getNotepadDtosByKidNo(NotepadSearchCondition condition, Pageable pageable) {
        Page<NotepadDto> notepads = notepadRepository.findAllByKidNo(condition, pageable);

        return notepads;
    }

    private Page<NotepadDto> getNotepadDtosByKinderNo(NotepadSearchCondition condition, Pageable pageable) {
        Page<NotepadDto> notepads = notepadRepository.findAllByKinderNo(condition, pageable);

        return notepads;
    }

}
