package com.aico.aibayo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QNotepadEntity is a Querydsl query type for NotepadEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QNotepadEntity extends EntityPathBase<NotepadEntity> {

    private static final long serialVersionUID = 1921828797L;

    public static final QNotepadEntity notepadEntity = new QNotepadEntity("notepadEntity");

    public final NumberPath<Long> boardNo = createNumber("boardNo", Long.class);

    public final StringPath hasLifeRecord = createString("hasLifeRecord");

    public final NumberPath<Long> notepadNo = createNumber("notepadNo", Long.class);

    public final NumberPath<Integer> weather = createNumber("weather", Integer.class);

    public QNotepadEntity(String variable) {
        super(NotepadEntity.class, forVariable(variable));
    }

    public QNotepadEntity(Path<? extends NotepadEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QNotepadEntity(PathMetadata metadata) {
        super(NotepadEntity.class, metadata);
    }

}

