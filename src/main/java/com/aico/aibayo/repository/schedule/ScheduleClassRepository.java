package com.aico.aibayo.repository.schedule;

import com.aico.aibayo.entity.ScheduleClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleClassRepository extends JpaRepository<ScheduleClassEntity, Long>, ScheduleClassRepositoryCustom {
}
