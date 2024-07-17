package com.aico.aibayo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMealEntity is a Querydsl query type for MealEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMealEntity extends EntityPathBase<MealEntity> {

    private static final long serialVersionUID = -1032002803L;

    public static final QMealEntity mealEntity = new QMealEntity("mealEntity");

    public final NumberPath<Long> kinderNo = createNumber("kinderNo", Long.class);

    public final DatePath<java.time.LocalDate> mealDate = createDate("mealDate", java.time.LocalDate.class);

    public final DateTimePath<java.time.LocalDateTime> mealDeleteDate = createDateTime("mealDeleteDate", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> mealModifyDate = createDateTime("mealModifyDate", java.time.LocalDateTime.class);

    public final NumberPath<Long> mealNo = createNumber("mealNo", Long.class);

    public final DateTimePath<java.time.LocalDateTime> mealRegDate = createDateTime("mealRegDate", java.time.LocalDateTime.class);

    public QMealEntity(String variable) {
        super(MealEntity.class, forVariable(variable));
    }

    public QMealEntity(Path<? extends MealEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMealEntity(PathMetadata metadata) {
        super(MealEntity.class, metadata);
    }

}

