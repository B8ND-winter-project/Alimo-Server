package com.b1nd.alimoserver.domain.role.adapter.out.persistence.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QRoleJpaEntity is a Querydsl query type for RoleJpaEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRoleJpaEntity extends EntityPathBase<RoleJpaEntity> {

    private static final long serialVersionUID = 2121555232L;

    public static final QRoleJpaEntity roleJpaEntity = new QRoleJpaEntity("roleJpaEntity");

    public final NumberPath<Long> roleId = createNumber("roleId", Long.class);

    public final StringPath roleName = createString("roleName");

    public QRoleJpaEntity(String variable) {
        super(RoleJpaEntity.class, forVariable(variable));
    }

    public QRoleJpaEntity(Path<? extends RoleJpaEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoleJpaEntity(PathMetadata metadata) {
        super(RoleJpaEntity.class, metadata);
    }

}

