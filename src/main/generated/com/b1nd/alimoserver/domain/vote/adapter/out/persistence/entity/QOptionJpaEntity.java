package com.b1nd.alimoserver.domain.vote.adapter.out.persistence.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QOptionJpaEntity is a Querydsl query type for OptionJpaEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOptionJpaEntity extends EntityPathBase<OptionJpaEntity> {

    private static final long serialVersionUID = -503433971L;

    public static final QOptionJpaEntity optionJpaEntity = new QOptionJpaEntity("optionJpaEntity");

    public final com.b1nd.alimoserver.global.lib.jpa.QBaseTimeEntity _super = new com.b1nd.alimoserver.global.lib.jpa.QBaseTimeEntity(this);

    public final StringPath content = createString("content");

    public final NumberPath<Long> count = createNumber("count", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final NumberPath<Long> optionId = createNumber("optionId", Long.class);

    public QOptionJpaEntity(String variable) {
        super(OptionJpaEntity.class, forVariable(variable));
    }

    public QOptionJpaEntity(Path<? extends OptionJpaEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOptionJpaEntity(PathMetadata metadata) {
        super(OptionJpaEntity.class, metadata);
    }

}

