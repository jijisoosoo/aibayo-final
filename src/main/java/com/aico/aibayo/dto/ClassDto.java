package com.aico.aibayo.dto;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ClassDto {
    private Long classNo;
    private String className;
    private String classAge;
    private int kinderNo;
    private LocalDateTime classRegDate;
    private LocalDateTime classModifyDate;
    private LocalDateTime classDeleteDate;
    private String classDeleteFlag;
}
