package com.aico.aibayo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMemberEntity is a Querydsl query type for MemberEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberEntity extends EntityPathBase<MemberEntity> {

    private static final long serialVersionUID = 1063671524L;

    public static final QMemberEntity memberEntity = new QMemberEntity("memberEntity");

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> inactivateDate = createDateTime("inactivateDate", java.time.LocalDateTime.class);

    public final NumberPath<Long> kinderNo = createNumber("kinderNo", Long.class);

    public final StringPath latestIp = createString("latestIp");

    public final DateTimePath<java.time.LocalDateTime> latestLogDate = createDateTime("latestLogDate", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> modifyDate = createDateTime("modifyDate", java.time.LocalDateTime.class);

    public final StringPath name = createString("name");

    public final StringPath pw = createString("pw");

    public final DateTimePath<java.time.LocalDateTime> regDate = createDateTime("regDate", java.time.LocalDateTime.class);

    public final NumberPath<Integer> regType = createNumber("regType", Integer.class);

    public final NumberPath<Integer> roleNo = createNumber("roleNo", Integer.class);

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public QMemberEntity(String variable) {
        super(MemberEntity.class, forVariable(variable));
    }

    public QMemberEntity(Path<? extends MemberEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMemberEntity(PathMetadata metadata) {
        super(MemberEntity.class, metadata);
    }

}

