package com.b1nd.alimoserver.domain.notification.adapter.out.persistence.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QNotificationJpaEntity is a Querydsl query type for NotificationJpaEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QNotificationJpaEntity extends EntityPathBase<NotificationJpaEntity> {

    private static final long serialVersionUID = -93931018L;

    public static final QNotificationJpaEntity notificationJpaEntity = new QNotificationJpaEntity("notificationJpaEntity");

    public final com.b1nd.alimoserver.global.lib.jpa.QBaseTimeEntity _super = new com.b1nd.alimoserver.global.lib.jpa.QBaseTimeEntity(this);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final NumberPath<Long> notificationId = createNumber("notificationId", Long.class);

    public QNotificationJpaEntity(String variable) {
        super(NotificationJpaEntity.class, forVariable(variable));
    }

    public QNotificationJpaEntity(Path<? extends NotificationJpaEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QNotificationJpaEntity(PathMetadata metadata) {
        super(NotificationJpaEntity.class, metadata);
    }

}

