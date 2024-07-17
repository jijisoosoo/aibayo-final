package com.aico.aibayo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QRegisterKinderEntity is a Querydsl query type for RegisterKinderEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRegisterKinderEntity extends EntityPathBase<RegisterKinderEntity> {

    private static final long serialVersionUID = -1978460786L;

    public static final QRegisterKinderEntity registerKinderEntity = new QRegisterKinderEntity("registerKinderEntity");

    public final NumberPath<Integer> announceStatus = createNumber("announceStatus", Integer.class);

    public final NumberPath<Integer> attendanceStatus = createNumber("attendanceStatus", Integer.class);

    public final NumberPath<Integer> chatStatus = createNumber("chatStatus", Integer.class);

    public final StringPath kinderCode = createString("kinderCode");

    public final DateTimePath<java.time.LocalDateTime> kinderDeleteDate = createDateTime("kinderDeleteDate", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> kinderKidDrop = createDateTime("kinderKidDrop", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> kinderKidPickup = createDateTime("kinderKidPickup", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> kinderModifyDate = createDateTime("kinderModifyDate", java.time.LocalDateTime.class);

    public final NumberPath<Long> kinderNo = createNumber("kinderNo", Long.class);

    public final DateTimePath<java.time.LocalDateTime> kinderRegDate = createDateTime("kinderRegDate", java.time.LocalDateTime.class);

    public final StringPath ldgrId = createString("ldgrId");

    public final NumberPath<Integer> lifeRecordStatus = createNumber("lifeRecordStatus", Integer.class);

    public final NumberPath<Integer> mealStatus = createNumber("mealStatus", Integer.class);

    public final NumberPath<Integer> medicationStatus = createNumber("medicationStatus", Integer.class);

    public final NumberPath<Integer> notepadStatus = createNumber("notepadStatus", Integer.class);

    public final NumberPath<Integer> pickDropStatus = createNumber("pickDropStatus", Integer.class);

    public final NumberPath<Integer> returnHomeStatus = createNumber("returnHomeStatus", Integer.class);

    public final NumberPath<Integer> scheduleStatus = createNumber("scheduleStatus", Integer.class);

    public QRegisterKinderEntity(String variable) {
        super(RegisterKinderEntity.class, forVariable(variable));
    }

    public QRegisterKinderEntity(Path<? extends RegisterKinderEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRegisterKinderEntity(PathMetadata metadata) {
        super(RegisterKinderEntity.class, metadata);
    }

}

