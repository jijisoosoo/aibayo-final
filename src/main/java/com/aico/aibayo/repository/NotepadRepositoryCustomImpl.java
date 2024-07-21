package com.aico.aibayo.repository;

import com.aico.aibayo.common.AcceptStatusEnum;
import com.aico.aibayo.common.BooleanEnum;
import com.aico.aibayo.dto.NotepadDto;
import com.aico.aibayo.dto.NotepadSearchCondition;
import com.aico.aibayo.entity.*;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPAExpressions;
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
import java.util.function.LongSupplier;

@RequiredArgsConstructor
public class NotepadRepositoryCustomImpl implements NotepadRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    private final QMemberEntity member = QMemberEntity.memberEntity;
    private final QBoardEntity board = QBoardEntity.boardEntity;
    private final QNotepadEntity notepad = QNotepadEntity.notepadEntity;
    private final QNotepadReceiverEntity notepadReceiver = QNotepadReceiverEntity.notepadReceiverEntity;
    private final QClassEntity clazz = QClassEntity.classEntity;
    private final QClassKidEntity classKid = QClassKidEntity.classKidEntity;
    private final QKidEntity kid = QKidEntity.kidEntity;
    private final QAcceptLogEntity acceptLog = QAcceptLogEntity.acceptLogEntity;
    private final QParentKidEntity parentKid = QParentKidEntity.parentKidEntity;
    private final QAcceptLogEntity acceptLog2 = QAcceptLogEntity.acceptLogEntity;

    @Override
    public Page<NotepadDto> findAllByKinderNo(NotepadSearchCondition condition, Pageable pageable) {

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
                        member.name,
                        member.kinderNo,
                        notepad.notepadNo))
                .from(notepad)
                .join(board).on(board.boardNo.eq(notepad.boardNo))
                .join(member).on(board.writer.eq(member.id))
                .where(
                        getInvisibleFlagEq(board),
                        getKinderNoEq(condition.getKinderNo(), member),
                        getBoardRegDateEq(condition.getBoardRegDate(), board)
                )
                .orderBy(board.boardRegDate.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> count = jpaQueryFactory.select(notepad.count())
                .from(notepad)
                .join(board).on(board.boardNo.eq(notepad.boardNo))
                .join(member).on(board.writer.eq(member.id))
                .where(
                        getInvisibleFlagEq(board),
                        getKinderNoEq(condition.getKinderNo(), member)
                );

        return PageableExecutionUtils.getPage(notepads, pageable, count::fetchOne);
    }

    @Override
    public Page<NotepadDto> findAllByKidNo(NotepadSearchCondition condition, Pageable pageable) {

        BooleanExpression kidNoOrClassNoCondition = notepadReceiver.kidNo.eq(kid.kidNo)
                .or(notepadReceiver.classNo.in(
                        JPAExpressions.select(classKid.classNo)
                                .from(classKid)
                                .join(acceptLog2).on(classKid.acceptNo.eq(acceptLog2.acceptNo))
                                .where(
                                        classKid.kidNo.eq(kid.kidNo),
                                        (isValidAcceptStatus())
                                )
                ));

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
                        member.name,
                        member.kinderNo,
                        notepad.notepadNo))
                .from(notepad)
                .join(board).on(board.boardNo.eq(notepad.boardNo))
                .join(member).on(board.writer.eq(member.id))
                .join(notepadReceiver).on(notepad.notepadNo.eq(notepadReceiver.notepadNo))
                .join(kid).on(kidNoOrClassNoCondition)
                .join(parentKid).on(parentKid.kidNo.eq(kid.kidNo))
                .join(acceptLog).on(acceptLog.acceptNo.eq(parentKid.acceptNo))
                .where(
                        getInvisibleFlagEq(board),
                        getKidNoEq(condition.getKidNo()),
                        isValidAcceptStatus(),
                        isValidKid(),
                        getBoardRegDateEq(condition.getBoardRegDate(), board)
                )
                .orderBy(board.boardRegDate.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> count = jpaQueryFactory.select(notepad.count())
                .from(notepad)
                .join(board).on(board.boardNo.eq(notepad.boardNo))
                .join(member).on(board.writer.eq(member.id))
                .join(notepadReceiver).on(notepad.notepadNo.eq(notepadReceiver.notepadNo))
                .join(kid).on(kidNoOrClassNoCondition)
                .join(parentKid).on(parentKid.kidNo.eq(kid.kidNo))
                .join(acceptLog).on(acceptLog.acceptNo.eq(parentKid.acceptNo))
                .where(
                        getInvisibleFlagEq(board),
                        getKidNoEq(condition.getKidNo()),
                        isValidAcceptStatus(),
                        isValidKid(),
                        getBoardRegDateEq(condition.getBoardRegDate(), board)
                );

        return PageableExecutionUtils.getPage(notepads, pageable, count::fetchOne);
    }

    private BooleanExpression isValidKid() {
        return kid.dischargeDate.isNull();
    }

    private BooleanExpression isValidAcceptStatus() {
        return acceptLog.acceptStatus.eq(AcceptStatusEnum.ACCEPT.getStatus());
    }

    private BooleanExpression getKidNoEq(Long kidNo) {
        return kidNo == null ? null : kid.kidNo.eq(kidNo);
    }

    private BooleanExpression getBoardRegDateEq(LocalDateTime boardRegDate, QBoardEntity board) {
        if (boardRegDate == null) {
            return null;
        }

        LocalDate date = boardRegDate.toLocalDate();
        LocalDateTime startDateTime = date.atStartOfDay();
        LocalDateTime endDateTime = date.atTime(LocalTime.MAX).minusSeconds(1L);

        return board.boardRegDate.between(startDateTime, endDateTime);
    }

    private BooleanExpression getKinderNoEq(Long kinderNo, QMemberEntity member) {
        return kinderNo == null ? null : member.kinderNo.eq(kinderNo);
    }

    private BooleanExpression getInvisibleFlagEq(QBoardEntity board) {
        return board.invisibleFlag.eq(BooleanEnum.FALSE.getBool());
    }
}
