package com.aico.aibayo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QReturnHomeAgreementEntity is a Querydsl query type for ReturnHomeAgreementEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReturnHomeAgreementEntity extends EntityPathBase<ReturnHomeAgreementEntity> {

    private static final long serialVersionUID = 7298039L;

    public static final QReturnHomeAgreementEntity returnHomeAgreementEntity = new QReturnHomeAgreementEntity("returnHomeAgreementEntity");

    public final NumberPath<Integer> orderNo = createNumber("orderNo", Integer.class);

    public final NumberPath<Long> rhAgreeNo = createNumber("rhAgreeNo", Long.class);

    public final DateTimePath<java.time.LocalDateTime> rhTime = createDateTime("rhTime", java.time.LocalDateTime.class);

    public final StringPath rhType = createString("rhType");

    public QReturnHomeAgreementEntity(String variable) {
        super(ReturnHomeAgreementEntity.class, forVariable(variable));
    }

    public QReturnHomeAgreementEntity(Path<? extends ReturnHomeAgreementEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReturnHomeAgreementEntity(PathMetadata metadata) {
        super(ReturnHomeAgreementEntity.class, metadata);
    }

}

