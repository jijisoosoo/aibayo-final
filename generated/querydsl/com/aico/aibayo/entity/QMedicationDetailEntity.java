package com.aico.aibayo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMedicationDetailEntity is a Querydsl query type for MedicationDetailEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMedicationDetailEntity extends EntityPathBase<MedicationDetailEntity> {

    private static final long serialVersionUID = -630254838L;

    public static final QMedicationDetailEntity medicationDetailEntity = new QMedicationDetailEntity("medicationDetailEntity");

    public final StringPath dosage = createString("dosage");

    public final StringPath doseCount = createString("doseCount");

    public final StringPath doseTime = createString("doseTime");

    public final NumberPath<Long> mediDetailNo = createNumber("mediDetailNo", Long.class);

    public final NumberPath<Integer> mediOrderNo = createNumber("mediOrderNo", Integer.class);

    public final StringPath mediType = createString("mediType");

    public final StringPath storageType = createString("storageType");

    public QMedicationDetailEntity(String variable) {
        super(MedicationDetailEntity.class, forVariable(variable));
    }

    public QMedicationDetailEntity(Path<? extends MedicationDetailEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMedicationDetailEntity(PathMetadata metadata) {
        super(MedicationDetailEntity.class, metadata);
    }

}

