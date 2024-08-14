package com.aico.aibayo.service.attendance;

import com.aico.aibayo.dto.attendance.AttendanceDto;
import com.aico.aibayo.entity.AttendanceEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AttendanceService {
    List<AttendanceDto> getKids(Long kinderNo, Long classNo);

    void createAttendance(AttendanceDto dto);
}
