package com.b1nd.alimoserver.domain.member.adapter.out.persistence.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMemberJpaEntity is a Querydsl query type for MemberJpaEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberJpaEntity extends EntityPathBase<MemberJpaEntity> {

    private static final long serialVersionUID = 438027160L;

    public static final QMemberJpaEntity memberJpaEntity = new QMemberJpaEntity("memberJpaEntity");

    public final StringPath email = createString("email");

    public final StringPath fcmToken = createString("fcmToken");

    public final NumberPath<Long> grade = createNumber("grade", Long.class);

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public QMemberJpaEntity(String variable) {
        super(MemberJpaEntity.class, forVariable(variable));
    }

    public QMemberJpaEntity(Path<? extends MemberJpaEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMemberJpaEntity(PathMetadata metadata) {
        super(MemberJpaEntity.class, metadata);
    }

}

