package com.aico.aibayo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMedicationOrderEntity is a Querydsl query type for MedicationOrderEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMedicationOrderEntity extends EntityPathBase<MedicationOrderEntity> {

    private static final long serialVersionUID = -878218597L;

    public static final QMedicationOrderEntity medicationOrderEntity = new QMedicationOrderEntity("medicationOrderEntity");

    public final NumberPath<Long> mediOrderNo = createNumber("mediOrderNo", Long.class);

    public final NumberPath<Integer> orderNo = createNumber("orderNo", Integer.class);

    public final StringPath symptoms = createString("symptoms");

    public QMedicationOrderEntity(String variable) {
        super(MedicationOrderEntity.class, forVariable(variable));
    }

    public QMedicationOrderEntity(Path<? extends MedicationOrderEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMedicationOrderEntity(PathMetadata metadata) {
        super(MedicationOrderEntity.class, metadata);
    }

}

