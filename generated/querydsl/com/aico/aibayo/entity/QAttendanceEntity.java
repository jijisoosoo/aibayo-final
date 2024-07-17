package com.aico.aibayo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAttendanceEntity is a Querydsl query type for AttendanceEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAttendanceEntity extends EntityPathBase<AttendanceEntity> {

    private static final long serialVersionUID = 1561771123L;

    public static final QAttendanceEntity attendanceEntity = new QAttendanceEntity("attendanceEntity");

    public final DateTimePath<java.time.LocalDateTime> attendanceDate = createDateTime("attendanceDate", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> attendanceDeleteDate = createDateTime("attendanceDeleteDate", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> attendanceModifyDate = createDateTime("attendanceModifyDate", java.time.LocalDateTime.class);

    public final NumberPath<Long> attendanceNo = createNumber("attendanceNo", Long.class);

    public final NumberPath<Integer> classNo = createNumber("classNo", Integer.class);

    public final StringPath excusedAbsence = createString("excusedAbsence");

    public final DateTimePath<java.time.LocalDateTime> kidDrop = createDateTime("kidDrop", java.time.LocalDateTime.class);

    public final NumberPath<Integer> kidNo = createNumber("kidNo", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> kidPickup = createDateTime("kidPickup", java.time.LocalDateTime.class);

    public final NumberPath<Integer> kinderNo = createNumber("kinderNo", Integer.class);

    public final StringPath note = createString("note");

    public QAttendanceEntity(String variable) {
        super(AttendanceEntity.class, forVariable(variable));
    }

    public QAttendanceEntity(Path<? extends AttendanceEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAttendanceEntity(PathMetadata metadata) {
        super(AttendanceEntity.class, metadata);
    }

}

