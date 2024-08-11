package com.aico.aibayo.service.meal;

import com.aico.aibayo.dto.meal.MealDetailDto;
import com.aico.aibayo.dto.meal.MealDto;
import com.aico.aibayo.dto.meal.MealSearchCondition;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface MealService {
    List<MealDto> getAllByMealDateAndKinderNoAndMealDeleteFlag(MealSearchCondition condition);
    MealDto getWithDetailByMealNo(MealDto dto);
    MealDto insertMeal(MealDto mealDto, List<MultipartFile> files);
}
