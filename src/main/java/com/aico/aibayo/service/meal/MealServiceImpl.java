package com.aico.aibayo.service.meal;

import com.aico.aibayo.common.BooleanEnum;
import com.aico.aibayo.dto.meal.MealDetailDto;
import com.aico.aibayo.dto.meal.MealDto;
import com.aico.aibayo.dto.meal.MealSearchCondition;
import com.aico.aibayo.entity.MealDetailEntity;
import com.aico.aibayo.entity.MealEntity;
import com.aico.aibayo.repository.meal.MealRepository;
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

//    @Override
//    public List<MealDetailDto> getWithDetailByMealNo(MealDto dto) {
//        if (dto == null || dto.getMealNo() == null) { return null; }
//
//        mealRepository.findById(dto.getMealNo()).ifPresent(target -> {
//            dto.set;
//        });
//        List<MealDetailEntity> mealDetailEntities =
//                mealRepository.findAllWithDetailByMealNo(dto.getMealNo());
//
//        return mealDetailEntities.stream()
//                .map(MealDetailDto::toDto)
//                .collect(Collectors.toList());
//
//    }

    @Override
    public MealDto getWithDetailByMealNo(MealDto dto) {
        if (dto != null && dto.getMealNo() != null) {

            return mealRepository.findById(dto.getMealNo()).map(target -> {
                List<MealDetailEntity> mealDetailEntities =
                        mealRepository.findAllWithDetailByMealNo(dto.getMealNo());

                List<MealDetailDto> mealDetailDtos =
                        mealDetailEntities.stream()
                                .map(MealDetailDto::toDto)
                                .toList();

                MealDto result = MealDto.toDto(target);

                result.setDetail(true);
                result.getMealDetails().addAll(mealDetailDtos);

                return result;
            }).orElse(null);
        }

        return null;

    }
}
