package com.aico.aibayo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QOrderFormEntity is a Querydsl query type for OrderFormEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOrderFormEntity extends EntityPathBase<OrderFormEntity> {

    private static final long serialVersionUID = -1669688690L;

    public static final QOrderFormEntity orderFormEntity = new QOrderFormEntity("orderFormEntity");

    public final NumberPath<Integer> kidNo = createNumber("kidNo", Integer.class);

    public final NumberPath<Integer> orderChecked = createNumber("orderChecked", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> orderDeleteDate = createDateTime("orderDeleteDate", java.time.LocalDateTime.class);

    public final NumberPath<Long> orderNo = createNumber("orderNo", Long.class);

    public final StringPath orderParentSign = createString("orderParentSign");

    public final StringPath orderRequester = createString("orderRequester");

    public final StringPath orderSpecific = createString("orderSpecific");

    public final NumberPath<Integer> orderType = createNumber("orderType", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> requestDate = createDateTime("requestDate", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> runDate = createDateTime("runDate", java.time.LocalDateTime.class);

    public QOrderFormEntity(String variable) {
        super(OrderFormEntity.class, forVariable(variable));
    }

    public QOrderFormEntity(Path<? extends OrderFormEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOrderFormEntity(PathMetadata metadata) {
        super(OrderFormEntity.class, metadata);
    }

}

