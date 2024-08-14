package com.aico.aibayo.repository.schedule;

import com.aico.aibayo.dto.schedule.ScheduleDto;
import com.aico.aibayo.entity.ScheduleEntity;
import com.aico.aibayo.repository.teacher.TeacherRepository;
import com.aico.aibayo.repository.teacher.TeacherRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Long>, ScheduleRepositoryCustom {

}
