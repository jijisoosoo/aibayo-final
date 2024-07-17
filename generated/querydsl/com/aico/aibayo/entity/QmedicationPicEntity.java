package com.aico.aibayo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QmedicationPicEntity is a Querydsl query type for medicationPicEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QmedicationPicEntity extends EntityPathBase<medicationPicEntity> {

    private static final long serialVersionUID = 1547641463L;

    public static final QmedicationPicEntity medicationPicEntity = new QmedicationPicEntity("medicationPicEntity");

    public final NumberPath<Long> mediOrderNo = createNumber("mediOrderNo", Long.class);

    public final StringPath mediPic = createString("mediPic");

    public final StringPath mediPicDesc = createString("mediPicDesc");

    public QmedicationPicEntity(String variable) {
        super(medicationPicEntity.class, forVariable(variable));
    }

    public QmedicationPicEntity(Path<? extends medicationPicEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QmedicationPicEntity(PathMetadata metadata) {
        super(medicationPicEntity.class, metadata);
    }

}

