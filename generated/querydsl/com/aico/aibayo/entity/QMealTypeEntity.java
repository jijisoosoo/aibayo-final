package com.aico.aibayo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMealTypeEntity is a Querydsl query type for MealTypeEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMealTypeEntity extends EntityPathBase<MealTypeEntity> {

    private static final long serialVersionUID = -1886198297L;

    public static final QMealTypeEntity mealTypeEntity = new QMealTypeEntity("mealTypeEntity");

    public final StringPath mealTypeName = createString("mealTypeName");

    public final NumberPath<Long> mealTypeNo = createNumber("mealTypeNo", Long.class);

    public QMealTypeEntity(String variable) {
        super(MealTypeEntity.class, forVariable(variable));
    }

    public QMealTypeEntity(Path<? extends MealTypeEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMealTypeEntity(PathMetadata metadata) {
        super(MealTypeEntity.class, metadata);
    }

}

