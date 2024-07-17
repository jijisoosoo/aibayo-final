package com.aico.aibayo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCommentEntity is a Querydsl query type for CommentEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCommentEntity extends EntityPathBase<CommentEntity> {

    private static final long serialVersionUID = -120038341L;

    public static final QCommentEntity commentEntity = new QCommentEntity("commentEntity");

    public final NumberPath<Integer> boardNo = createNumber("boardNo", Integer.class);

    public final StringPath commentClass = createString("commentClass");

    public final StringPath commentContent = createString("commentContent");

    public final DateTimePath<java.time.LocalDateTime> commentDeleteDate = createDateTime("commentDeleteDate", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> commentModifyDate = createDateTime("commentModifyDate", java.time.LocalDateTime.class);

    public final NumberPath<Long> commentNo = createNumber("commentNo", Long.class);

    public final NumberPath<Integer> commentOrder = createNumber("commentOrder", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> commentRegDate = createDateTime("commentRegDate", java.time.LocalDateTime.class);

    public final StringPath commentWriter = createString("commentWriter");

    public final NumberPath<Integer> commnetGroupNo = createNumber("commnetGroupNo", Integer.class);

    public final StringPath invisibleFlag = createString("invisibleFlag");

    public final NumberPath<Integer> parentCommentNo = createNumber("parentCommentNo", Integer.class);

    public QCommentEntity(String variable) {
        super(CommentEntity.class, forVariable(variable));
    }

    public QCommentEntity(Path<? extends CommentEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCommentEntity(PathMetadata metadata) {
        super(CommentEntity.class, metadata);
    }

}

