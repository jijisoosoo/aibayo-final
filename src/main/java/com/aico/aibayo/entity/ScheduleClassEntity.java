package com.aico.aibayo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "schedule_class")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ScheduleClassEntity {
    @Id
    @Column(name = "schedule_no")
    private Long scheduleNo;
    @Id
    @Column(name = "class_no")
    private Long classNo;
}
