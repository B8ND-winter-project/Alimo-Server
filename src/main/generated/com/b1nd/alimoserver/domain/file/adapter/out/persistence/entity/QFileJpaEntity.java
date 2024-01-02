package com.b1nd.alimoserver.domain.file.adapter.out.persistence.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QFileJpaEntity is a Querydsl query type for FileJpaEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFileJpaEntity extends EntityPathBase<FileJpaEntity> {

    private static final long serialVersionUID = -856478828L;

    public static final QFileJpaEntity fileJpaEntity = new QFileJpaEntity("fileJpaEntity");

    public final NumberPath<Long> fileId = createNumber("fileId", Long.class);

    public final StringPath fileName = createString("fileName");

    public final EnumPath<com.b1nd.alimoserver.domain.file.application.domain.model.enums.FileType> fileType = createEnum("fileType", com.b1nd.alimoserver.domain.file.application.domain.model.enums.FileType.class);

    public final StringPath fileUrl = createString("fileUrl");

    public QFileJpaEntity(String variable) {
        super(FileJpaEntity.class, forVariable(variable));
    }

    public QFileJpaEntity(Path<? extends FileJpaEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFileJpaEntity(PathMetadata metadata) {
        super(FileJpaEntity.class, metadata);
    }

}

