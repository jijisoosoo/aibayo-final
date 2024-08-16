package com.aico.aibayo.service;

import com.aico.aibayo.dto.ClassDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ScheduleClassService {
    List<ClassDto> getClassByScheduleNo(Long scheduleNo);
}
