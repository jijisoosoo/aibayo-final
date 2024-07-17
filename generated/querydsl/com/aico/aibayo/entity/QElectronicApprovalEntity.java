package com.aico.aibayo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QElectronicApprovalEntity is a Querydsl query type for ElectronicApprovalEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QElectronicApprovalEntity extends EntityPathBase<ElectronicApprovalEntity> {

    private static final long serialVersionUID = -2086587671L;

    public static final QElectronicApprovalEntity electronicApprovalEntity = new QElectronicApprovalEntity("electronicApprovalEntity");

    public final DateTimePath<java.time.LocalDateTime> approvalDeleteDate = createDateTime("approvalDeleteDate", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> approvalModifyDate = createDateTime("approvalModifyDate", java.time.LocalDateTime.class);

    public final NumberPath<Long> approvalNo = createNumber("approvalNo", Long.class);

    public final DateTimePath<java.time.LocalDateTime> approvalRegDate = createDateTime("approvalRegDate", java.time.LocalDateTime.class);

    public final StringPath approvalRejectReason = createString("approvalRejectReason");

    public final StringPath approvalRequestReason = createString("approvalRequestReason");

    public final NumberPath<Integer> approvalStatus = createNumber("approvalStatus", Integer.class);

    public final NumberPath<Integer> approvalType = createNumber("approvalType", Integer.class);

    public final DatePath<java.time.LocalDate> requestEndDate = createDate("requestEndDate", java.time.LocalDate.class);

    public final DatePath<java.time.LocalDate> requestStartDate = createDate("requestStartDate", java.time.LocalDate.class);

    public final StringPath writer = createString("writer");

    public QElectronicApprovalEntity(String variable) {
        super(ElectronicApprovalEntity.class, forVariable(variable));
    }

    public QElectronicApprovalEntity(Path<? extends ElectronicApprovalEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QElectronicApprovalEntity(PathMetadata metadata) {
        super(ElectronicApprovalEntity.class, metadata);
    }

}

