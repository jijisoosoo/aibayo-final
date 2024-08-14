package com.aico.aibayo.service.schedule;

import com.aico.aibayo.dto.schedule.ScheduleDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ScheduleService {
    List<ScheduleDto> getAllByKinderNo(Long kinderNo);
}
