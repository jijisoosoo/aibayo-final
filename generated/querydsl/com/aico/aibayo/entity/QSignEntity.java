package com.aico.aibayo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSignEntity is a Querydsl query type for SignEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSignEntity extends EntityPathBase<SignEntity> {

    private static final long serialVersionUID = -1503999609L;

    public static final QSignEntity signEntity = new QSignEntity("signEntity");

    public final StringPath fileName = createString("fileName");

    public final StringPath filePath = createString("filePath");

    public final StringPath orderParentId = createString("orderParentId");

    public final NumberPath<Long> orderParentSign = createNumber("orderParentSign", Long.class);

    public QSignEntity(String variable) {
        super(SignEntity.class, forVariable(variable));
    }

    public QSignEntity(Path<? extends SignEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSignEntity(PathMetadata metadata) {
        super(SignEntity.class, metadata);
    }

}

