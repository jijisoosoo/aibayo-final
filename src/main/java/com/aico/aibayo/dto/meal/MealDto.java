package com.aico.aibayo.dto.meal;

import com.aico.aibayo.entity.MealEntity;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MealDto {
    private Long mealNo;
    private Long kinderNo;
    private LocalDate mealDate;
    private LocalDateTime mealRegDate;
    private LocalDateTime mealModifyDate;
    private LocalDateTime mealDeleteDate;

    public static MealDto toDto(MealEntity entity) {
        if (entity == null) {
            return null;
        }

        return new MealDto(
                entity.getMealNo(),
                entity.getKinderNo(),
                entity.getMealDate(),
                entity.getMealRegDate(),
                entity.getMealModifyDate(),
                entity.getMealDeleteDate()
        );
    }
}
