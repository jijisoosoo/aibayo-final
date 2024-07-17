package com.aico.aibayo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QClassEntity is a Querydsl query type for ClassEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QClassEntity extends EntityPathBase<ClassEntity> {

    private static final long serialVersionUID = 2087916244L;

    public static final QClassEntity classEntity = new QClassEntity("classEntity");

    public final StringPath classAge = createString("classAge");

    public final DateTimePath<java.time.LocalDateTime> classDeleteDate = createDateTime("classDeleteDate", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> classModifyDate = createDateTime("classModifyDate", java.time.LocalDateTime.class);

    public final StringPath className = createString("className");

    public final NumberPath<Integer> classNo = createNumber("classNo", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> classRegDate = createDateTime("classRegDate", java.time.LocalDateTime.class);

    public final NumberPath<Integer> kinderNo = createNumber("kinderNo", Integer.class);

    public QClassEntity(String variable) {
        super(ClassEntity.class, forVariable(variable));
    }

    public QClassEntity(Path<? extends ClassEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QClassEntity(PathMetadata metadata) {
        super(ClassEntity.class, metadata);
    }

}

