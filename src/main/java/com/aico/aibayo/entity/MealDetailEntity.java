package com.aico.aibayo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "meal_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MealDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meal_detail_no")
    private Long mealDetailNo;
    @Column(name = "meal_no")
    private Long mealNo;
    @Column(name = "meal_type")
    private int mealType;
    @Column(name = "meal_menu")
    private String mealMenu;
    @Column(name = "meal_pic")
    private String mealPic;
    @Column(name = "meal_pic_original_name")
    private String mealPicOriginalName;
}
