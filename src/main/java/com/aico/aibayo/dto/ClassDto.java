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

    private Long acceptNo;

    private Long assignedCnt;

    public ClassDto(Long classNo, String className) {
        this.classNo = classNo;
        this.className = className;
    }

    public ClassDto(Long classNo, String className, Long assignedCnt) {
        this.classNo = classNo;
        this.className = className;
        this.assignedCnt = assignedCnt;
    }

    public ClassDto(Long classNo, String className, String classAge, Long kinderNo,
                    LocalDateTime classRegDate, LocalDateTime classModifyDate, LocalDateTime classDeleteDate,
                    String classDeleteFlag, Long acceptNo) {
        this.classNo = classNo;
        this.className = className;
        this.classAge = classAge;
        this.kinderNo = kinderNo;
        this.classRegDate = classRegDate;
        this.classModifyDate = classModifyDate;
        this.classDeleteDate = classDeleteDate;
        this.classDeleteFlag = classDeleteFlag;
        this.acceptNo = acceptNo;
    }

    public ClassDto(Long classNo, String className, String classAge, Long kinderNo,
                    LocalDateTime classRegDate, LocalDateTime classModifyDate, LocalDateTime classDeleteDate,
                    String classDeleteFlag) {
        this.classNo = classNo;
        this.className = className;
        this.classAge = classAge;
        this.kinderNo = kinderNo;
        this.classRegDate = classRegDate;
        this.classModifyDate = classModifyDate;
        this.classDeleteDate = classDeleteDate;
        this.classDeleteFlag = classDeleteFlag;
    }

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
