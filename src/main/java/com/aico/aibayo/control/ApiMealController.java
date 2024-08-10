package com.aico.aibayo.control;

import com.aico.aibayo.dto.meal.MealDetailDto;
import com.aico.aibayo.dto.meal.MealDto;
import com.aico.aibayo.dto.meal.MealSearchCondition;
import com.aico.aibayo.service.meal.MealService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/meal")
@RequiredArgsConstructor
public class ApiMealController {
    private final MealService mealService;

    @PostMapping("/getByMonth")
    public ResponseEntity<List<MealDto>> getByMonth(@RequestBody MealSearchCondition condition) {
        List<MealDto> mealDtos = mealService.getAllByMealDateAndKinderNoAndMealDeleteFlag(condition);

        return mealDtos == null ? ResponseEntity.badRequest().build() :
                                  ResponseEntity.ok(mealDtos);
    }

    @PostMapping("/detail")
    public ResponseEntity<MealDto> adminDetail(@RequestBody MealDto dto) {
        MealDto result = mealService.getWithDetailByMealNo(dto);

        return result == null ? ResponseEntity.badRequest().build() :
                                ResponseEntity.ok(result);
    }
}
