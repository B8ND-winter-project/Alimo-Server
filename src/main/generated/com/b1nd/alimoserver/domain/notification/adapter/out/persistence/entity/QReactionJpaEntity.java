package com.b1nd.alimoserver.domain.notification.adapter.out.persistence.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QReactionJpaEntity is a Querydsl query type for ReactionJpaEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReactionJpaEntity extends EntityPathBase<ReactionJpaEntity> {

    private static final long serialVersionUID = -915871752L;

    public static final QReactionJpaEntity reactionJpaEntity = new QReactionJpaEntity("reactionJpaEntity");

    public final EnumPath<com.b1nd.alimoserver.domain.notification.application.domain.model.enums.Emoji> emoji = createEnum("emoji", com.b1nd.alimoserver.domain.notification.application.domain.model.enums.Emoji.class);

    public final NumberPath<Long> reactionId = createNumber("reactionId", Long.class);

    public QReactionJpaEntity(String variable) {
        super(ReactionJpaEntity.class, forVariable(variable));
    }

    public QReactionJpaEntity(Path<? extends ReactionJpaEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReactionJpaEntity(PathMetadata metadata) {
        super(ReactionJpaEntity.class, metadata);
    }

}

