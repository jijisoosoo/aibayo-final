package com.aico.aibayo.service.meal;

import com.aico.aibayo.common.BooleanEnum;
import com.aico.aibayo.dto.meal.MealDto;
import com.aico.aibayo.dto.meal.MealSearchCondition;
import com.aico.aibayo.entity.MealEntity;
import com.aico.aibayo.repository.MealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MealServiceImpl implements MealService {
    private final MealRepository mealRepository;

    @Override
    public List<MealDto> getAllByMealDateAndKinderNoAndMealDeleteFlag(MealSearchCondition condition) {
        if (condition == null || condition.getStartDate() == null || condition.getEndDate() == null) {
            return null;
        }

        List<MealEntity> mealEntities = mealRepository.findAllByMealDateBetweenAndKinderNoAndMealDeleteFlag
                (
                        condition.getStartDate(),
                        condition.getEndDate(),
                        condition.getKinderNo(),
                        BooleanEnum.FALSE.getBool()
                );

        return mealEntities.stream()
                           .map(MealDto::toDto)
                           .collect(Collectors.toList());
    }
}
