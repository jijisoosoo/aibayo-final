package com.aico.aibayo.repository.meal;

import com.aico.aibayo.entity.MealDetailEntity;

import java.util.List;

public interface MealRepositoryCustom {
    List<MealDetailEntity> findAllWithDetailByMealNo(Long mealNo);
}
