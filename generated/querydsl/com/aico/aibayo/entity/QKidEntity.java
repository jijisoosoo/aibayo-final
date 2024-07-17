package com.aico.aibayo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QKidEntity is a Querydsl query type for KidEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QKidEntity extends EntityPathBase<KidEntity> {

    private static final long serialVersionUID = 221796322L;

    public static final QKidEntity kidEntity = new QKidEntity("kidEntity");

    public final DateTimePath<java.time.LocalDateTime> admissionDate = createDateTime("admissionDate", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> dischargeDate = createDateTime("dischargeDate", java.time.LocalDateTime.class);

    public final DatePath<java.time.LocalDate> kidBirth = createDate("kidBirth", java.time.LocalDate.class);

    public final NumberPath<Integer> kidGender = createNumber("kidGender", Integer.class);

    public final StringPath kidName = createString("kidName");

    public final NumberPath<Long> kidNo = createNumber("kidNo", Long.class);

    public final NumberPath<Long> kinderNo = createNumber("kinderNo", Long.class);

    public final DateTimePath<java.time.LocalDateTime> modifyDate = createDateTime("modifyDate", java.time.LocalDateTime.class);

    public QKidEntity(String variable) {
        super(KidEntity.class, forVariable(variable));
    }

    public QKidEntity(Path<? extends KidEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QKidEntity(PathMetadata metadata) {
        super(KidEntity.class, metadata);
    }

}

