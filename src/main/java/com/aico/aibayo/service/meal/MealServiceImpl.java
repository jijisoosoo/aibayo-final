package com.aico.aibayo.service.meal;

import com.aico.aibayo.common.BooleanEnum;
import com.aico.aibayo.dto.meal.MealDetailDto;
import com.aico.aibayo.dto.meal.MealDto;
import com.aico.aibayo.dto.meal.MealSearchCondition;
import com.aico.aibayo.entity.MealDetailEntity;
import com.aico.aibayo.entity.MealEntity;
import com.aico.aibayo.repository.meal.MealDetailRepository;
import com.aico.aibayo.repository.meal.MealRepository;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class MealServiceImpl implements MealService {
    private final MealRepository mealRepository;
    private final MealDetailRepository mealDetailRepository;

    @Value("${file.upload-dir}")
    private String uploadDirectory;

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

    @Override
    public MealDto getWithDetailByMealNo(MealDto dto) {
        if (dto != null && dto.getMealNo() != null) {

            return mealRepository.findById(dto.getMealNo()).map(target -> {
                List<MealDetailEntity> mealDetailEntities =
                        mealRepository.findAllWithDetailByMealNo(dto.getMealNo());

                List<MealDetailDto> mealDetailDtos =
                        mealDetailEntities.stream()
                                .map(entity -> {
                                    MealDetailDto detailDto = MealDetailDto.toDto(entity);

                                    if (detailDto.getMealPic() != null) {
                                        String filePath = uploadDirectory + File.separator + detailDto.getMealPic();
                                        detailDto.setMealPic(filePath);
                                    }

                                    return detailDto;
                                })
                                .toList();

                MealDto result = MealDto.toDto(target);

                result.setDetail(true);
                result.getMealDetails().addAll(mealDetailDtos);

                return result;
            }).orElse(null);
        }

        return null;

    }

    @Override
    @Transactional
    public MealDto insertMeal(MealDto mealDto, List<MultipartFile> files) {
        MealEntity target = MealEntity.builder()
                .kinderNo(mealDto.getKinderNo())
                .mealDate(mealDto.getMealDate())
                .mealRegDate(LocalDateTime.now())
                .mealDeleteFlag(BooleanEnum.FALSE.getBool())
                .mealDetails(new ArrayList<>())
                .build();

        MealEntity saved = mealRepository.save(target);

        List<MealDetailEntity> savedDetails = new ArrayList<>();
        List<MealDetailDto> mealDetails = mealDto.getMealDetails();
        for (int i = 0; i < mealDetails.size(); i++) {
            MealDetailDto mealDetailDto = mealDetails.get(i);

            File uploadDir = new File(uploadDirectory);
            MultipartFile file = files.get(i);

            // 서버에 파일 등록
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            String fileName = UUID.randomUUID() + "-" + file.getOriginalFilename();
            String filePath = uploadDirectory + "/" + fileName;
            File upload = new File(filePath);

            try {
                file.transferTo(upload);

                MealDetailEntity mealDetailEntity = MealDetailEntity.builder()
                        .mealType(mealDetailDto.getMealType())
                        .mealMenu(mealDetailDto.getMealMenu())
                        .mealPic(fileName)
                        .mealPicOriginalName(file.getOriginalFilename())
                        .mealInvisibleFlag(BooleanEnum.FALSE.getBool())
                        .meal(saved)
                        .build();

                MealDetailEntity savedDetail = mealDetailRepository.save(mealDetailEntity);
                savedDetails.add(savedDetail);
            } catch (IOException e) {
                throw new RuntimeException();
            }

            saved.setMealDetails(savedDetails);
        }

        return MealDto.toDto(saved);
    }
}
