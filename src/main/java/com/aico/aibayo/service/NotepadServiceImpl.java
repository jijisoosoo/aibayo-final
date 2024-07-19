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
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotepadServiceImpl implements NotepadService {
    private final NotepadRepository notepadRepository;

    @Override
    public List<NotepadDto> getAllByKinderNo(Long kinderNo) {

        List<NotepadDto> notepads = notepadRepository.findAllByKinderNo(kinderNo);

        notepads.forEach(tuple -> log.info("\n{}", tuple.toString()));

        return notepads;
    }
}
