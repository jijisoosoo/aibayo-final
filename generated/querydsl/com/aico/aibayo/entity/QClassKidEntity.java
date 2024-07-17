package com.aico.aibayo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QClassKidEntity is a Querydsl query type for ClassKidEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QClassKidEntity extends EntityPathBase<ClassKidEntity> {

    private static final long serialVersionUID = 961110456L;

    public static final QClassKidEntity classKidEntity = new QClassKidEntity("classKidEntity");

    public final NumberPath<Integer> acceptNo = createNumber("acceptNo", Integer.class);

    public final NumberPath<Integer> classNo = createNumber("classNo", Integer.class);

    public final NumberPath<Integer> kidNo = createNumber("kidNo", Integer.class);

    public QClassKidEntity(String variable) {
        super(ClassKidEntity.class, forVariable(variable));
    }

    public QClassKidEntity(Path<? extends ClassKidEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QClassKidEntity(PathMetadata metadata) {
        super(ClassKidEntity.class, metadata);
    }

}

