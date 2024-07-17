package com.aico.aibayo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QParentKidEntity is a Querydsl query type for ParentKidEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QParentKidEntity extends EntityPathBase<ParentKidEntity> {

    private static final long serialVersionUID = 918763416L;

    public static final QParentKidEntity parentKidEntity = new QParentKidEntity("parentKidEntity");

    public final NumberPath<Long> acceptNo = createNumber("acceptNo", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath isMainParent = createString("isMainParent");

    public final NumberPath<Long> kidNo = createNumber("kidNo", Long.class);

    public final StringPath parentRelationship = createString("parentRelationship");

    public QParentKidEntity(String variable) {
        super(ParentKidEntity.class, forVariable(variable));
    }

    public QParentKidEntity(Path<? extends ParentKidEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QParentKidEntity(PathMetadata metadata) {
        super(ParentKidEntity.class, metadata);
    }

}

