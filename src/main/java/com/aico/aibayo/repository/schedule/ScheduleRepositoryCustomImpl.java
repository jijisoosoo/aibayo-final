package com.aico.aibayo.repository.schedule;

import com.aico.aibayo.common.BoardTypeEnum;
import com.aico.aibayo.common.BooleanEnum;
import com.aico.aibayo.dto.schedule.ScheduleDto;
import com.aico.aibayo.entity.*;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ScheduleRepositoryCustomImpl implements ScheduleRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    private final QBoardEntity board = QBoardEntity.boardEntity;
    private final QScheduleEntity schedule = QScheduleEntity.scheduleEntity;
    private final QScheduleClassEntity scheduleClass = QScheduleClassEntity.scheduleClassEntity;
    private final QClassEntity classEntity = QClassEntity.classEntity;

    @Override
    public List<ScheduleDto> findAllByKinderNo(Long kinderNo) {
        List<ScheduleDto> schedules = jpaQueryFactory
                .select(Projections.constructor(ScheduleDto.class,
                        board.boardNo,
                        schedule.scheduleNo,
                        board.kinderNo,
                        scheduleClass.classNo,
                        board.boardTitle,
                        board.writer,
                        board.boardContents,
                        schedule.scheduleStartDate,
                        schedule.scheduleEndDate))
                .from(board)
                .join(schedule).on(board.boardNo.eq(schedule.boardNo))
                .join(scheduleClass).on(schedule.scheduleNo.eq(scheduleClass.scheduleNo))
                .where(board.kinderNo.eq(kinderNo),
                        board.boardType.eq(BoardTypeEnum.SCHEDULE.getNum()),
                        board.invisibleFlag.eq(BooleanEnum.FALSE.getBool())
                )
                .fetch();
        return schedules;
    }
}
