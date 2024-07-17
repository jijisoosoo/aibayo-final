package com.aico.aibayo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QScheduleClassEntity is a Querydsl query type for ScheduleClassEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QScheduleClassEntity extends EntityPathBase<ScheduleClassEntity> {

    private static final long serialVersionUID = -833156419L;

    public static final QScheduleClassEntity scheduleClassEntity = new QScheduleClassEntity("scheduleClassEntity");

    public final NumberPath<Integer> classNo = createNumber("classNo", Integer.class);

    public final NumberPath<Integer> scheduleNo = createNumber("scheduleNo", Integer.class);

    public QScheduleClassEntity(String variable) {
        super(ScheduleClassEntity.class, forVariable(variable));
    }

    public QScheduleClassEntity(Path<? extends ScheduleClassEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QScheduleClassEntity(PathMetadata metadata) {
        super(ScheduleClassEntity.class, metadata);
    }

}

