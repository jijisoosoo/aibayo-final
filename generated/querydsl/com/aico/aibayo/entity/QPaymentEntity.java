package com.aico.aibayo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPaymentEntity is a Querydsl query type for PaymentEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPaymentEntity extends EntityPathBase<PaymentEntity> {

    private static final long serialVersionUID = -1535048030L;

    public static final QPaymentEntity paymentEntity = new QPaymentEntity("paymentEntity");

    public final NumberPath<Integer> categoryNo = createNumber("categoryNo", Integer.class);

    public final NumberPath<Integer> categoryType = createNumber("categoryType", Integer.class);

    public final NumberPath<Integer> discountNo = createNumber("discountNo", Integer.class);

    public final NumberPath<Integer> kidNo = createNumber("kidNo", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> paymentEndDate = createDateTime("paymentEndDate", java.time.LocalDateTime.class);

    public final StringPath paymentMemo = createString("paymentMemo");

    public final DateTimePath<java.time.LocalDateTime> paymentPayDate = createDateTime("paymentPayDate", java.time.LocalDateTime.class);

    public final NumberPath<Integer> paymentPrice = createNumber("paymentPrice", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> paymentStartDate = createDateTime("paymentStartDate", java.time.LocalDateTime.class);

    public final NumberPath<Integer> paymentStatus = createNumber("paymentStatus", Integer.class);

    public final NumberPath<Integer> requestNo = createNumber("requestNo", Integer.class);

    public QPaymentEntity(String variable) {
        super(PaymentEntity.class, forVariable(variable));
    }

    public QPaymentEntity(Path<? extends PaymentEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPaymentEntity(PathMetadata metadata) {
        super(PaymentEntity.class, metadata);
    }

}

