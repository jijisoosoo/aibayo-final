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
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping("/writeOk")
    public ResponseEntity<MealDto> writeOk(@RequestPart(value = "mealDto") MealDto mealDto,
                                           @RequestPart(value = "files") List<MultipartFile> files){
        log.info("mealDto: {}", mealDto);
        for (MultipartFile file : files) {
            log.info("file: {}", file.getOriginalFilename());
        }

        MealDto inserted = mealService.insertMeal(mealDto, files);

        return inserted == null ? ResponseEntity.badRequest().build() :
                                  ResponseEntity.ok(inserted);
    }
}
