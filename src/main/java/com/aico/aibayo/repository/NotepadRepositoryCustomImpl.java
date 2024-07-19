package com.aico.aibayo.repository;

import com.aico.aibayo.common.BooleanEnum;
import com.aico.aibayo.dto.NotepadDto;
import com.aico.aibayo.entity.*;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

import java.util.List;

@RequiredArgsConstructor
public class NotepadRepositoryCustomImpl implements NotepadRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<NotepadDto> findAllByKinderNo(Long kinderNo, Pageable pageable) {
        QMemberEntity member = QMemberEntity.memberEntity;
        QBoardEntity board = QBoardEntity.boardEntity;
        QNotepadEntity notepad = QNotepadEntity.notepadEntity;

        List<NotepadDto> notepads = jpaQueryFactory
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
                .where(
                        board.invisibleFlag.eq(BooleanEnum.FALSE.getBool()),
                        member.kinderNo.eq(kinderNo)
                )
                .orderBy(board.boardRegDate.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> count = jpaQueryFactory.select(notepad.count())
                .from(notepad)
                .join(board).on(board.boardNo.eq(notepad.boardNo))
                .join(member).on(board.writer.eq(member.name))
                .where(
                        board.invisibleFlag.eq(BooleanEnum.FALSE.getBool()),
                        member.kinderNo.eq(kinderNo)
                );

        return PageableExecutionUtils.getPage(notepads, pageable, count::fetchOne);
    }
}
