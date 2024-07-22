package com.aico.aibayo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "teacher_kinder")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class TeacherKinderEntity {
    @Id
    @Column(name = "teacher_id")
    private Long teacherId;
    @Id
    @Column(name = "accept_no")
    private int acceptNo;
}
