package com.aico.aibayo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMealDetailEntity is a Querydsl query type for MealDetailEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMealDetailEntity extends EntityPathBase<MealDetailEntity> {

    private static final long serialVersionUID = 998055742L;

    public static final QMealDetailEntity mealDetailEntity = new QMealDetailEntity("mealDetailEntity");

    public final NumberPath<Long> mealDetailNo = createNumber("mealDetailNo", Long.class);

    public final StringPath mealMenu = createString("mealMenu");

    public final NumberPath<Long> mealNo = createNumber("mealNo", Long.class);

    public final StringPath mealPic = createString("mealPic");

    public final StringPath mealPicOriginalName = createString("mealPicOriginalName");

    public final NumberPath<Integer> mealType = createNumber("mealType", Integer.class);

    public QMealDetailEntity(String variable) {
        super(MealDetailEntity.class, forVariable(variable));
    }

    public QMealDetailEntity(Path<? extends MealDetailEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMealDetailEntity(PathMetadata metadata) {
        super(MealDetailEntity.class, metadata);
    }

}

