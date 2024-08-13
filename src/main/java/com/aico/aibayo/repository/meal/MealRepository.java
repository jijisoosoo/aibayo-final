package com.aico.aibayo.repository.meal;

import com.aico.aibayo.entity.MealEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MealRepository extends JpaRepository<MealEntity, Long>, MealRepositoryCustom {
//    List<MealEntity> findAllByMealDateBetweenAndKinderNoAndMealDeleteFlag(
//            LocalDate startDate,
//            LocalDate endDate,
//            Long kinderNo,
//            String deleteFlag);
}
