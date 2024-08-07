package com.aico.aibayo.dto.meal;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MealSearchCondition {
    private LocalDate startDate;
    private LocalDate endDate;
    private Long kinderNo;
}
