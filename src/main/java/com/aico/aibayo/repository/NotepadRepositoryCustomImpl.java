package com.aico.aibayo.repository;

import com.aico.aibayo.common.BooleanEnum;
import com.aico.aibayo.dto.NotepadDto;
import com.aico.aibayo.dto.NotepadSearchCondition;
import com.aico.aibayo.entity.*;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RequiredArgsConstructor
public class NotepadRepositoryCustomImpl implements NotepadRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<NotepadDto> findAllByKinderNo(NotepadSearchCondition cond, Pageable pageable) {
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
                        getInvisibleFlagEq(board),
                        getKinderNoEq(cond.getKinderNo(), member),
                        getBoardRegDateEq(cond.getBoardRegDate(), board)
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
                        getInvisibleFlagEq(board),
                        getKinderNoEq(cond.getKinderNo(), member)
                );

        return PageableExecutionUtils.getPage(notepads, pageable, count::fetchOne);
    }

    private static BooleanExpression getBoardRegDateEq(LocalDateTime boardRegDate, QBoardEntity board) {
        if (boardRegDate == null) {
            return null;
        }

        LocalDate date = boardRegDate.toLocalDate();
        LocalDateTime startDateTime = date.atStartOfDay();
        LocalDateTime endDateTime = date.atTime(LocalTime.MAX);

        return board.boardRegDate.between(startDateTime, endDateTime);
    }

    private static BooleanExpression getKinderNoEq(Long kinderNo, QMemberEntity member) {
        return kinderNo == null ? null : member.kinderNo.eq(kinderNo);
    }

    private static BooleanExpression getInvisibleFlagEq(QBoardEntity board) {
        return board.invisibleFlag.eq(BooleanEnum.FALSE.getBool());
    }
}
