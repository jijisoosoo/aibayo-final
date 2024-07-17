package com.aico.aibayo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QTeacherKinderEntity is a Querydsl query type for TeacherKinderEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTeacherKinderEntity extends EntityPathBase<TeacherKinderEntity> {

    private static final long serialVersionUID = 571528671L;

    public static final QTeacherKinderEntity teacherKinderEntity = new QTeacherKinderEntity("teacherKinderEntity");

    public final NumberPath<Integer> acceptNo = createNumber("acceptNo", Integer.class);

    public final StringPath kinderNo = createString("kinderNo");

    public final StringPath teacherId = createString("teacherId");

    public QTeacherKinderEntity(String variable) {
        super(TeacherKinderEntity.class, forVariable(variable));
    }

    public QTeacherKinderEntity(Path<? extends TeacherKinderEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTeacherKinderEntity(PathMetadata metadata) {
        super(TeacherKinderEntity.class, metadata);
    }

}

