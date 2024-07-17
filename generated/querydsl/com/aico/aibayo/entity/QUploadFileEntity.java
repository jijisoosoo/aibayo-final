package com.aico.aibayo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUploadFileEntity is a Querydsl query type for UploadFileEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUploadFileEntity extends EntityPathBase<UploadFileEntity> {

    private static final long serialVersionUID = 1896772007L;

    public static final QUploadFileEntity uploadFileEntity = new QUploadFileEntity("uploadFileEntity");

    public final NumberPath<Long> approvalNo = createNumber("approvalNo", Long.class);

    public final NumberPath<Long> boardNo = createNumber("boardNo", Long.class);

    public final StringPath upload_file_is_deleted = createString("upload_file_is_deleted");

    public final NumberPath<Long> uploadFileNo = createNumber("uploadFileNo", Long.class);

    public final StringPath uploadFileOriginName = createString("uploadFileOriginName");

    public final StringPath uploadFileSaveName = createString("uploadFileSaveName");

    public QUploadFileEntity(String variable) {
        super(UploadFileEntity.class, forVariable(variable));
    }

    public QUploadFileEntity(Path<? extends UploadFileEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUploadFileEntity(PathMetadata metadata) {
        super(UploadFileEntity.class, metadata);
    }

}

