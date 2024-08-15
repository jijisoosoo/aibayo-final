package com.aico.aibayo.service.schedule;

import com.aico.aibayo.dto.schedule.ScheduleDto;
import com.aico.aibayo.dto.schedule.ScheduleSearchCondition;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ScheduleService {
    List<ScheduleDto> getAllByKinderNo(ScheduleSearchCondition condition);

    List<ScheduleDto> getListByDay(ScheduleSearchCondition condition);

    List<ScheduleDto> getListByClass(ScheduleSearchCondition condition);

    void insertSchedule(Map<String, Object> requestBody);
}
