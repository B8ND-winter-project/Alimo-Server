package com.b1nd.alimoserver.domain.comment.adapter.out.persistence.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCommentJpaEntity is a Querydsl query type for CommentJpaEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCommentJpaEntity extends EntityPathBase<CommentJpaEntity> {

    private static final long serialVersionUID = 156468970L;

    public static final QCommentJpaEntity commentJpaEntity = new QCommentJpaEntity("commentJpaEntity");

    public final com.b1nd.alimoserver.global.lib.jpa.QBaseTimeEntity _super = new com.b1nd.alimoserver.global.lib.jpa.QBaseTimeEntity(this);

    public final NumberPath<Long> commentId = createNumber("commentId", Long.class);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public QCommentJpaEntity(String variable) {
        super(CommentJpaEntity.class, forVariable(variable));
    }

    public QCommentJpaEntity(Path<? extends CommentJpaEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCommentJpaEntity(PathMetadata metadata) {
        super(CommentJpaEntity.class, metadata);
    }

}

