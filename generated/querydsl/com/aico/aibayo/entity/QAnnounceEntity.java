package com.aico.aibayo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAnnounceEntity is a Querydsl query type for AnnounceEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAnnounceEntity extends EntityPathBase<AnnounceEntity> {

    private static final long serialVersionUID = 1452520371L;

    public static final QAnnounceEntity announceEntity = new QAnnounceEntity("announceEntity");

    public final NumberPath<Long> announceNo = createNumber("announceNo", Long.class);

    public final StringPath announcePrimary = createString("announcePrimary");

    public final NumberPath<Integer> announceType = createNumber("announceType", Integer.class);

    public final NumberPath<Integer> boardNo = createNumber("boardNo", Integer.class);

    public final StringPath canComment = createString("canComment");

    public QAnnounceEntity(String variable) {
        super(AnnounceEntity.class, forVariable(variable));
    }

    public QAnnounceEntity(Path<? extends AnnounceEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAnnounceEntity(PathMetadata metadata) {
        super(AnnounceEntity.class, metadata);
    }

}

