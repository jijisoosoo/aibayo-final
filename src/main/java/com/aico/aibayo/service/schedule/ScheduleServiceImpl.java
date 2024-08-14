package com.aico.aibayo.service.schedule;

import com.aico.aibayo.dto.schedule.ScheduleDto;
import com.aico.aibayo.dto.schedule.ScheduleSearchCondition;
import com.aico.aibayo.repository.schedule.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleRepository scheduleRepository;

    @Override
    public List<ScheduleDto> getAllByKinderNo(ScheduleSearchCondition condition) {
        return scheduleRepository.findAllByKinderNo(condition);
    }

    @Override
    public List<ScheduleDto> getListByDay(ScheduleSearchCondition condition) {
        return scheduleRepository.findListByDay(condition);
    }

    @Override
    public List<ScheduleDto> getListByClass(ScheduleSearchCondition condition) {
        return scheduleRepository.findListByClass(condition);
    }
}
