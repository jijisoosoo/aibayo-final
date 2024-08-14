package com.aico.aibayo.repository.schedule;

import com.aico.aibayo.dto.schedule.ScheduleDto;
import com.aico.aibayo.dto.schedule.ScheduleSearchCondition;

import java.util.List;

public interface ScheduleRepositoryCustom {
    List<ScheduleDto> findAllByKinderNo(ScheduleSearchCondition condition);
    List<ScheduleDto> findListByDay(ScheduleSearchCondition condition);
    List<ScheduleDto> findListByClass(ScheduleSearchCondition condition);
}
