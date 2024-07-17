package com.aico.aibayo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QClassTeacherEntity is a Querydsl query type for ClassTeacherEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QClassTeacherEntity extends EntityPathBase<ClassTeacherEntity> {

    private static final long serialVersionUID = -280561068L;

    public static final QClassTeacherEntity classTeacherEntity = new QClassTeacherEntity("classTeacherEntity");

    public final NumberPath<Integer> acceptNo = createNumber("acceptNo", Integer.class);

    public final NumberPath<Integer> acceptStatus = createNumber("acceptStatus", Integer.class);

    public final NumberPath<Integer> classNo = createNumber("classNo", Integer.class);

    public final StringPath classTeacherId = createString("classTeacherId");

    public QClassTeacherEntity(String variable) {
        super(ClassTeacherEntity.class, forVariable(variable));
    }

    public QClassTeacherEntity(Path<? extends ClassTeacherEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QClassTeacherEntity(PathMetadata metadata) {
        super(ClassTeacherEntity.class, metadata);
    }

}

