package com.aico.aibayo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "schedule")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ScheduleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_no")
    private Long scheduleNo;
    @Column(name = "board_no")
    private int boardNo;
    @Column(name = "schedule_start_date")
    private int scheduleStartDate;
    @Column(name = "schedule_end_date")
    private int scheduleEndDate;
}
