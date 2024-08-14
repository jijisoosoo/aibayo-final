package com.aico.aibayo.repository.schedule;

import com.aico.aibayo.dto.schedule.ScheduleDto;

import java.util.List;

public interface ScheduleRepositoryCustom {
    List<ScheduleDto> findAllByKinderNo(Long kinderNo);
}
