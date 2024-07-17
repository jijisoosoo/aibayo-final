package com.aico.aibayo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QReturnHomeAgreementParentEntity is a Querydsl query type for ReturnHomeAgreementParentEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReturnHomeAgreementParentEntity extends EntityPathBase<ReturnHomeAgreementParentEntity> {

    private static final long serialVersionUID = 570378817L;

    public static final QReturnHomeAgreementParentEntity returnHomeAgreementParentEntity = new QReturnHomeAgreementParentEntity("returnHomeAgreementParentEntity");

    public final NumberPath<Integer> rhAgreeNo = createNumber("rhAgreeNo", Integer.class);

    public final StringPath rhAgreeParentName = createString("rhAgreeParentName");

    public final NumberPath<Long> rhAgreeParentNo = createNumber("rhAgreeParentNo", Long.class);

    public final StringPath rhAgreeParentTel = createString("rhAgreeParentTel");

    public final NumberPath<Integer> rhAgreeParentType = createNumber("rhAgreeParentType", Integer.class);

    public QReturnHomeAgreementParentEntity(String variable) {
        super(ReturnHomeAgreementParentEntity.class, forVariable(variable));
    }

    public QReturnHomeAgreementParentEntity(Path<? extends ReturnHomeAgreementParentEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReturnHomeAgreementParentEntity(PathMetadata metadata) {
        super(ReturnHomeAgreementParentEntity.class, metadata);
    }

}

