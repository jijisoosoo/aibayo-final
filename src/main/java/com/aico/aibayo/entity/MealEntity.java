package com.aico.aibayo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "meal")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MealEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meal_no")
    private Long mealNo;
    @Column(name = "kinder_no")
    private Long kinderNo;
    @Column(name = "meal_date")
    private LocalDate mealDate;
    @Column(name = "meal_reg_date")
    private LocalDateTime mealRegDate;
    @Column(name = "meal_modify_date")
    private LocalDateTime mealModifyDate;
    @Column(name = "meal_delete_date")
    private LocalDateTime mealDeleteDate;
}
