package com.b1nd.alimoserver.domain.vote.adapter.out.persistence.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QVoteJpaEntity is a Querydsl query type for VoteJpaEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QVoteJpaEntity extends EntityPathBase<VoteJpaEntity> {

    private static final long serialVersionUID = -1986156744L;

    public static final QVoteJpaEntity voteJpaEntity = new QVoteJpaEntity("voteJpaEntity");

    public final com.b1nd.alimoserver.global.infra.jpa.QBaseTimeEntity _super = new com.b1nd.alimoserver.global.infra.jpa.QBaseTimeEntity(this);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final NumberPath<Long> voteId = createNumber("voteId", Long.class);

    public QVoteJpaEntity(String variable) {
        super(VoteJpaEntity.class, forVariable(variable));
    }

    public QVoteJpaEntity(Path<? extends VoteJpaEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QVoteJpaEntity(PathMetadata metadata) {
        super(VoteJpaEntity.class, metadata);
    }

}

