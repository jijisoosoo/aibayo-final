package com.aico.aibayo.repository.schedule;

import com.aico.aibayo.common.BooleanEnum;
import com.aico.aibayo.dto.ClassDto;
import com.aico.aibayo.entity.QBoardEntity;
import com.aico.aibayo.entity.QClassEntity;
import com.aico.aibayo.entity.QScheduleClassEntity;
import com.aico.aibayo.entity.QScheduleEntity;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ScheduleClassRepositoryCustomImpl implements ScheduleClassRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    private final QClassEntity clazz = QClassEntity.classEntity;
    private final QScheduleEntity schedule = QScheduleEntity.scheduleEntity;
    private final QScheduleClassEntity scheduleClass = QScheduleClassEntity.scheduleClassEntity;
    private final QBoardEntity board = QBoardEntity.boardEntity;

    @Override
    public List<ClassDto> findClassByScheduleNo(Long scheduleNo) {
        List<ClassDto> classes = jpaQueryFactory
                .select(Projections.constructor(ClassDto.class,
                        clazz.classNo,
                        clazz.className,
                        clazz.kinderNo))
                .from(clazz)
                .join(scheduleClass).on(clazz.classNo.eq(scheduleClass.classNo))
                .join(schedule).on(scheduleClass.scheduleNo.eq(schedule.scheduleNo))
                .join(board).on(schedule.boardNo.eq(board.boardNo))
                .where(scheduleClass.scheduleNo.eq(scheduleNo),
                        board.invisibleFlag.eq(BooleanEnum.FALSE.getBool()))
                .fetch();

        return classes;

    }
}
