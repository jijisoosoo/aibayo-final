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
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


@Slf4j
@Service
@RequiredArgsConstructor
public class MealServiceImpl implements MealService {
    private final AmazonS3Client amazonS3Client;

    private final MealRepository mealRepository;
    private final MealDetailRepository mealDetailRepository;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;
    @Value("${file.upload-dir}")
    private String uploadDirectory;

    private final String MEAL_IMG_DIR = "meal";

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

            MultipartFile multipartFile = files.get(i);
            File uploadDir = new File(uploadDirectory);

            // 로컬에 파일 등록
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            String fileName = UUID.randomUUID() + "-" + multipartFile.getName();
            String filePathLocal = uploadDirectory + File.separator + fileName;
            String filePathS3 = MEAL_IMG_DIR + "/" + fileName;


            try {
                File uploadLocal = new File(filePathLocal);
                multipartFile.transferTo(uploadLocal);

                // s3 파일 등록
                amazonS3Client.putObject(new PutObjectRequest(bucket, filePathS3, uploadLocal));

                // 로컬 파일 삭제
                if (uploadLocal.delete()) {
                    log.info(">>>>>>>>>>> local meal file delete succeed");
                } else {
                    log.info(">>>>>>>>>>> local meal file delete failed");
                }

            } catch (IOException e) {
                throw new RuntimeException("Failed to upload file", e);
            }

            String uploadUrl = amazonS3Client.getUrl(bucket, filePathS3).toString();
            log.info(">>>>>>>>> meal file saved in {}", uploadUrl);


            MealDetailEntity mealDetailEntity = MealDetailEntity.builder()
                    .mealType(mealDetailDto.getMealType())
                    .mealMenu(mealDetailDto.getMealMenu())
                    .mealPic(uploadUrl)
                    .mealPicOriginalName(multipartFile.getOriginalFilename())
                    .mealInvisibleFlag(BooleanEnum.FALSE.getBool())
                    .meal(saved)
                    .build();

            MealDetailEntity savedDetail = mealDetailRepository.save(mealDetailEntity);
            savedDetails.add(savedDetail);

            saved.setMealDetails(savedDetails);
        }

        return MealDto.toDto(saved);
    }
}
