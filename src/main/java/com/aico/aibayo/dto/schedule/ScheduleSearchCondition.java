package com.aico.aibayo.dto.schedule;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class ScheduleSearchCondition {

    private Long kinderNo;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime selectedDate;

    private Long scheduleNo;
    private Long classNo;

}
