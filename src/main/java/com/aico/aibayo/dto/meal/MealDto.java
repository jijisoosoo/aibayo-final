package com.aico.aibayo.dto.meal;

import com.aico.aibayo.entity.MealDetailEntity;
import com.aico.aibayo.entity.MealEntity;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    private List<MealDetailDto> mealDetails = new ArrayList<>();

    private boolean isDetail;

    public MealDto(Long mealNo, Long kinderNo, LocalDate mealDate, LocalDateTime mealRegDate, LocalDateTime mealModifyDate, LocalDateTime mealDeleteDate) {
        this.mealNo = mealNo;
        this.kinderNo = kinderNo;
        this.mealDate = mealDate;
        this.mealRegDate = mealRegDate;
        this.mealModifyDate = mealModifyDate;
        this.mealDeleteDate = mealDeleteDate;
    }

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
