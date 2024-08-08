package com.aico.aibayo.service.meal;

import com.aico.aibayo.dto.meal.MealDto;
import com.aico.aibayo.dto.meal.MealSearchCondition;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MealService {
    List<MealDto> getAllByMealDateAndKinderNoAndMealDeleteFlag(MealSearchCondition condition);
}
