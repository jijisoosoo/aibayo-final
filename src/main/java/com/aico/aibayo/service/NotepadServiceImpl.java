package com.aico.aibayo.service;

import com.aico.aibayo.dto.NotepadDto;
//import com.aico.aibayo.entity.QNotepadEntity;
import com.aico.aibayo.entity.*;
import com.aico.aibayo.repository.NotepadReceiverRepository;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotepadServiceImpl implements NotepadService {
    private final NotepadReceiverRepository notepadReceiverRepository;
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<NotepadEntity> getAllByKinderNo(int kinderNo) {
//        return notepadReceiverRepository.findAll();
//        QNotepadEntity qNotepad = new QNotepadEntity();
        QMemberEntity member = QMemberEntity.memberEntity;
        QBoardEntity board = QBoardEntity.boardEntity;
        QNotepadEntity notepad = QNotepadEntity.notepadEntity;
        List<Tuple> fetchAll = jpaQueryFactory.select(notepad, board, member)
                .from(notepad)
                .join(board).on(board.boardNo.eq(notepad.boardNo))
                .join(member).on(board.writer.eq(member.name))
                .where(board.invisibleFlag.eq(BooleanEnum.FALSE.getBool()))
                .where(member.kinderNo.eq(1L))
                .fetch();

        fetchAll.forEach(System.out :: println);

        return List.of();
    }
}
