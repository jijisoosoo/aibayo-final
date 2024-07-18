package com.aico.aibayo.repository;

import com.aico.aibayo.entity.*;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class NotepadRepositoryCustomImpl implements NotepadRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Tuple> findAllByKinderNo(Long kinderNo) {
        QMemberEntity member = QMemberEntity.memberEntity;
        QBoardEntity board = QBoardEntity.boardEntity;
        QNotepadEntity notepad = QNotepadEntity.notepadEntity;

        return jpaQueryFactory.select(notepad, board, member)
                              .from(notepad)
                              .join(board).on(board.boardNo.eq(notepad.boardNo))
                              .join(member).on(board.writer.eq(member.name))
                              .where(board.invisibleFlag.eq(BooleanEnum.FALSE.getBool())
                                    .and(member.kinderNo.eq(kinderNo)))
                              .fetch();
    }
}
