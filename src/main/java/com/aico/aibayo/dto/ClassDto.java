package com.aico.aibayo.dto;

import com.aico.aibayo.entity.ClassEntity;
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
    private Long kinderNo;
    private LocalDateTime classRegDate;
    private LocalDateTime classModifyDate;
    private LocalDateTime classDeleteDate;
    private String classDeleteFlag;

    public static ClassDto toDto(ClassEntity entity) {
        return new ClassDto(
                entity.getClassNo(),
                entity.getClassName(),
                entity.getClassAge(),
                entity.getKinderNo(),
                entity.getClassRegDate(),
                entity.getClassModifyDate(),
                entity.getClassDeleteDate(),
                entity.getClassDeleteFlag()
        );
    }
}
