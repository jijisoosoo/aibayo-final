package com.aico.aibayo.repository.schedule;

import com.aico.aibayo.common.BoardTypeEnum;
import com.aico.aibayo.common.BooleanEnum;
import com.aico.aibayo.dto.schedule.ScheduleDto;
import com.aico.aibayo.dto.schedule.ScheduleSearchCondition;
import com.aico.aibayo.entity.*;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ScheduleRepositoryCustomImpl implements ScheduleRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    private final QClassEntity clazz = QClassEntity.classEntity;
    private final QBoardEntity board = QBoardEntity.boardEntity;
    private final QScheduleEntity schedule = QScheduleEntity.scheduleEntity;
    private final QScheduleClassEntity scheduleClass = QScheduleClassEntity.scheduleClassEntity;

    @Override
    public List<ScheduleDto> findAllByKinderNo(ScheduleSearchCondition condition) {

        List<ScheduleDto> schedules = jpaQueryFactory
                .select(Projections.constructor(ScheduleDto.class,
                        board.boardNo,
                        schedule.scheduleNo,
                        board.kinderNo,
                        board.boardTitle,
                        board.writer,
                        board.boardContents,
                        schedule.scheduleStartDate,
                        schedule.scheduleEndDate
                ))
                .from(board)
                .join(schedule).on(board.boardNo.eq(schedule.boardNo))
                .where(board.kinderNo.eq(condition.getKinderNo()),
                        board.boardType.eq(BoardTypeEnum.SCHEDULE.getNum()),
                        board.invisibleFlag.eq(BooleanEnum.FALSE.getBool())
                )
                .fetch();
        return schedules;
    }

    @Override
    public List<ScheduleDto> findListByDay(ScheduleSearchCondition condition) {
        List<ScheduleDto> schedules = jpaQueryFactory
                .select(Projections.constructor(ScheduleDto.class,
                        board.boardNo,
                        schedule.scheduleNo,
                        board.kinderNo,
                        board.boardTitle,
                        board.writer,
                        board.boardContents,
                        schedule.scheduleStartDate,
                        schedule.scheduleEndDate
                )).distinct()
                .from(board)
                .join(schedule).on(board.boardNo.eq(schedule.boardNo))
                .join(scheduleClass).on(schedule.scheduleNo.eq(scheduleClass.scheduleNo))
                .where(schedule.scheduleStartDate.loe(condition.getSelectedDate()),
                        schedule.scheduleEndDate.goe(condition.getSelectedDate()),
                        getClassNoEq(condition.getClassNo())
                )
                .fetch();
        return schedules;
    }

    @Override
    public List<ScheduleDto> findListByClass(ScheduleSearchCondition condition) {
        List<ScheduleDto> schedules = jpaQueryFactory
                .select(Projections.constructor(ScheduleDto.class,
                        board.boardNo,
                        schedule.scheduleNo,
                        board.kinderNo,
                        board.boardTitle,
                        board.writer,
                        board.boardContents,
                        schedule.scheduleStartDate,
                        schedule.scheduleEndDate
                )).distinct()
                .from(board)
                .join(schedule).on(board.boardNo.eq(schedule.boardNo))
                .join(scheduleClass).on(schedule.scheduleNo.eq(scheduleClass.scheduleNo))
                .where(getClassNoEq(condition.getClassNo()),
                        board.boardType.eq(BoardTypeEnum.SCHEDULE.getNum()),
                        board.invisibleFlag.eq(BooleanEnum.FALSE.getBool())
                )
                .fetch();
        return schedules;
    }

    private BooleanExpression getClassNoEq(Long classNo) {
        if (classNo == null) {
            return null; // null인 경우 전체 조건을 무시
        } else {
            return scheduleClass.classNo.eq(classNo).or(scheduleClass.classNo.eq(0L));
        }
    }
}
