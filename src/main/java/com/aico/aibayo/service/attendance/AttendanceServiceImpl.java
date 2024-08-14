package com.aico.aibayo.service.attendance;

import com.aico.aibayo.dto.attendance.AttendanceDto;
import com.aico.aibayo.entity.AttendanceEntity;
import com.aico.aibayo.repository.attendance.AttendanceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {
    private final AttendanceRepository attendanceRepository;

    @Override
    public List<AttendanceDto> getKids(Long kinderNo, Long classNo) {
        return attendanceRepository.findAllByKinderNoAndClassNo(kinderNo, classNo);
    }

    @Override
    public void createAttendance(AttendanceDto dto) {
        AttendanceEntity attendanceEntity = new AttendanceEntity();
        attendanceEntity.setAttendanceDate(LocalDate.now());
        attendanceEntity.setKinderNo(dto.getKinderNo());
        attendanceEntity.setClassNo(dto.getClassNo());
        attendanceEntity.setKidNo(dto.getKidNo());
        attendanceEntity.setAttendanceStatus(dto.getAttendanceStatus());
        attendanceEntity.setKidDrop(dto.getKidDrop());
        attendanceEntity.setKidPickup(dto.getKidPickup());
        attendanceEntity.setNote(dto.getNote());
        attendanceRepository.save(attendanceEntity);
        System.out.println("create attendance done");
    }
}
