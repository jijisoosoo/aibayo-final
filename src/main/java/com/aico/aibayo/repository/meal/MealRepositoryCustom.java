package com.aico.aibayo.repository.meal;

import com.aico.aibayo.entity.MealDetailEntity;
import com.aico.aibayo.entity.MealEntity;

import java.util.List;

public interface MealRepositoryCustom {
//    List<MealDetailEntity> findAllWithDetailByMealNo(Long mealNo);
    MealEntity findByMealNo(Long mealNo);
}
