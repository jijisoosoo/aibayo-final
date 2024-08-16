package com.aico.aibayo.repository.schedule;

import com.aico.aibayo.dto.ClassDto;

import java.util.List;

public interface ScheduleClassRepositoryCustom {
    List<ClassDto> findClassByScheduleNo(Long scheduleNo);
}
