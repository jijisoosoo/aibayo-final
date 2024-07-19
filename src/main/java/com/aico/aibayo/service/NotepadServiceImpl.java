package com.aico.aibayo.service;

import com.aico.aibayo.dto.NotepadDto;
//import com.aico.aibayo.entity.QNotepadEntity;
import com.aico.aibayo.entity.*;
import com.aico.aibayo.repository.NotepadReceiverRepository;
import com.aico.aibayo.repository.NotepadRepository;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotepadServiceImpl implements NotepadService {
    private final NotepadRepository notepadRepository;
    private static final int PAGE_SIZE = 6;

    @Override
    public Page<NotepadDto> getAllByKinderNo(Long kinderNo, int page) {
        Pageable pageable = PageRequest.of(page, PAGE_SIZE);
        Page<NotepadDto> notepads = notepadRepository.findAllByKinderNo(kinderNo, pageable);

        notepads.forEach(tuple -> log.info("\n{}", tuple.toString()));

        return notepads;
    }
}
