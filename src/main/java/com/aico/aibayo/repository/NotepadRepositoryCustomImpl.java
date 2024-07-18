package com.aico.aibayo.repository;

import com.aico.aibayo.dto.NotepadDto;
import com.aico.aibayo.entity.*;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class NotepadRepositoryCustomImpl implements NotepadRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<NotepadDto> findAllByKinderNo(Long kinderNo) {
        QMemberEntity member = QMemberEntity.memberEntity;
        QBoardEntity board = QBoardEntity.boardEntity;
        QNotepadEntity notepad = QNotepadEntity.notepadEntity;

        return jpaQueryFactory
                .select(Projections.constructor(NotepadDto.class,
                        board.boardNo,
                        board.boardType,
                        board.writer,
                        board.boardTitle,
                        board.boardContents,
                        board.invisibleFlag,
                        board.boardRegDate,
                        member.id,
                        member.kinderNo,
                        notepad.notepadNo))
                .from(notepad)
                .join(board).on(board.boardNo.eq(notepad.boardNo))
                .join(member).on(board.writer.eq(member.name))
                .where(board.invisibleFlag.eq(BooleanEnum.FALSE.getBool())
                        .and(member.kinderNo.eq(kinderNo)))
                .fetch();
    }
}
