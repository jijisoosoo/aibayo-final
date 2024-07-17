package com.aico.aibayo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QNotepadReceiverEntity is a Querydsl query type for NotepadReceiverEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QNotepadReceiverEntity extends EntityPathBase<NotepadReceiverEntity> {

    private static final long serialVersionUID = -653282164L;

    public static final QNotepadReceiverEntity notepadReceiverEntity = new QNotepadReceiverEntity("notepadReceiverEntity");

    public final NumberPath<Long> classNo = createNumber("classNo", Long.class);

    public final NumberPath<Long> kidNo = createNumber("kidNo", Long.class);

    public final NumberPath<Long> notepadNo = createNumber("notepadNo", Long.class);

    public QNotepadReceiverEntity(String variable) {
        super(NotepadReceiverEntity.class, forVariable(variable));
    }

    public QNotepadReceiverEntity(Path<? extends NotepadReceiverEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QNotepadReceiverEntity(PathMetadata metadata) {
        super(NotepadReceiverEntity.class, metadata);
    }

}

