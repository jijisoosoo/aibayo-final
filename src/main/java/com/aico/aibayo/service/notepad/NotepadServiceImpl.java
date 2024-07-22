package com.aico.aibayo.service.notepad;

import com.aico.aibayo.dto.notepad.NotepadDto;
//import com.aico.aibayo.entity.QNotepadEntity;
import com.aico.aibayo.dto.notepad.NotepadSearchCondition;
import com.aico.aibayo.repository.notepad.NotepadRepository;
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
    public Page<NotepadDto> getAllByKinderNo(NotepadSearchCondition condition, int page) {
        Pageable pageable = PageRequest.of(page - 1, PAGE_SIZE);

        return notepadRepository.findAllByKinderNo(condition, pageable);
    }

    @Override
    public Page<NotepadDto> getAllByKidNo(NotepadSearchCondition condition, int page) {
        Pageable pageable = PageRequest.of(page - 1, PAGE_SIZE);

        return notepadRepository.findAllByKidNo(condition, pageable);
    }

    @Override
    public NotepadDto getByNotepadNo(Long notepadNo) {
        return notepadRepository.findByNotepadNo(notepadNo);
    }

}
