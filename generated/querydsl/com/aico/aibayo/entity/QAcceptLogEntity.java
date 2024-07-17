package com.aico.aibayo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAcceptLogEntity is a Querydsl query type for AcceptLogEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAcceptLogEntity extends EntityPathBase<AcceptLogEntity> {

    private static final long serialVersionUID = -1996635400L;

    public static final QAcceptLogEntity acceptLogEntity = new QAcceptLogEntity("acceptLogEntity");

    public final DateTimePath<java.time.LocalDateTime> acceptDate = createDateTime("acceptDate", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> acceptDeleteDate = createDateTime("acceptDeleteDate", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> acceptModifyDate = createDateTime("acceptModifyDate", java.time.LocalDateTime.class);

    public final NumberPath<Integer> acceptNo = createNumber("acceptNo", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> acceptRegDate = createDateTime("acceptRegDate", java.time.LocalDateTime.class);

    public final NumberPath<Integer> acceptStatus = createNumber("acceptStatus", Integer.class);

    public final NumberPath<Integer> acceptType = createNumber("acceptType", Integer.class);

    public final NumberPath<Integer> codeVerify = createNumber("codeVerify", Integer.class);

    public QAcceptLogEntity(String variable) {
        super(AcceptLogEntity.class, forVariable(variable));
    }

    public QAcceptLogEntity(Path<? extends AcceptLogEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAcceptLogEntity(PathMetadata metadata) {
        super(AcceptLogEntity.class, metadata);
    }

}

