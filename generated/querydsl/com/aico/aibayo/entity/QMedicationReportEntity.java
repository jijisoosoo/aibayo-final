package com.aico.aibayo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMedicationReportEntity is a Querydsl query type for MedicationReportEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMedicationReportEntity extends EntityPathBase<MedicationReportEntity> {

    private static final long serialVersionUID = -556082771L;

    public static final QMedicationReportEntity medicationReportEntity = new QMedicationReportEntity("medicationReportEntity");

    public final NumberPath<Long> mediOrderNo = createNumber("mediOrderNo", Long.class);

    public final StringPath mediReportSpecific = createString("mediReportSpecific");

    public QMedicationReportEntity(String variable) {
        super(MedicationReportEntity.class, forVariable(variable));
    }

    public QMedicationReportEntity(Path<? extends MedicationReportEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMedicationReportEntity(PathMetadata metadata) {
        super(MedicationReportEntity.class, metadata);
    }

}

