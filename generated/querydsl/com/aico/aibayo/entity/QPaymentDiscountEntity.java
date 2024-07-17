package com.aico.aibayo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPaymentDiscountEntity is a Querydsl query type for PaymentDiscountEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPaymentDiscountEntity extends EntityPathBase<PaymentDiscountEntity> {

    private static final long serialVersionUID = -226196413L;

    public static final QPaymentDiscountEntity paymentDiscountEntity = new QPaymentDiscountEntity("paymentDiscountEntity");

    public final NumberPath<Integer> discountNo = createNumber("discountNo", Integer.class);

    public final NumberPath<Integer> discountRate = createNumber("discountRate", Integer.class);

    public final NumberPath<Integer> discountType = createNumber("discountType", Integer.class);

    public QPaymentDiscountEntity(String variable) {
        super(PaymentDiscountEntity.class, forVariable(variable));
    }

    public QPaymentDiscountEntity(Path<? extends PaymentDiscountEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPaymentDiscountEntity(PathMetadata metadata) {
        super(PaymentDiscountEntity.class, metadata);
    }

}

