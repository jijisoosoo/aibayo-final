package com.aico.aibayo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAnnounceMemberEntity is a Querydsl query type for AnnounceMemberEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAnnounceMemberEntity extends EntityPathBase<AnnounceMemberEntity> {

    private static final long serialVersionUID = 233059053L;

    public static final QAnnounceMemberEntity announceMemberEntity = new QAnnounceMemberEntity("announceMemberEntity");

    public final NumberPath<Long> announceNo = createNumber("announceNo", Long.class);

    public final StringPath id = createString("id");

    public final StringPath isRead = createString("isRead");

    public QAnnounceMemberEntity(String variable) {
        super(AnnounceMemberEntity.class, forVariable(variable));
    }

    public QAnnounceMemberEntity(Path<? extends AnnounceMemberEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAnnounceMemberEntity(PathMetadata metadata) {
        super(AnnounceMemberEntity.class, metadata);
    }

}

