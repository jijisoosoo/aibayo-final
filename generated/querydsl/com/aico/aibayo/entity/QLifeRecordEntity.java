package com.aico.aibayo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QLifeRecordEntity is a Querydsl query type for LifeRecordEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLifeRecordEntity extends EntityPathBase<LifeRecordEntity> {

    private static final long serialVersionUID = -211418889L;

    public static final QLifeRecordEntity lifeRecordEntity = new QLifeRecordEntity("lifeRecordEntity");

    public final NumberPath<Integer> defecationStatus = createNumber("defecationStatus", Integer.class);

    public final NumberPath<Integer> health = createNumber("health", Integer.class);

    public final NumberPath<Integer> meal = createNumber("meal", Integer.class);

    public final NumberPath<Integer> mood = createNumber("mood", Integer.class);

    public final NumberPath<Long> notepadNo = createNumber("notepadNo", Long.class);

    public final NumberPath<Integer> sleepTime = createNumber("sleepTime", Integer.class);

    public final NumberPath<Integer> temperature = createNumber("temperature", Integer.class);

    public QLifeRecordEntity(String variable) {
        super(LifeRecordEntity.class, forVariable(variable));
    }

    public QLifeRecordEntity(Path<? extends LifeRecordEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLifeRecordEntity(PathMetadata metadata) {
        super(LifeRecordEntity.class, metadata);
    }

}

