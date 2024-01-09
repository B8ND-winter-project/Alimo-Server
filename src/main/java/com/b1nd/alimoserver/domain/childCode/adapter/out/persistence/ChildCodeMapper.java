package com.b1nd.alimoserver.domain.childCode.adapter.out.persistence;

import com.b1nd.alimoserver.domain.childCode.adapter.out.persistence.entity.ChildCodeJpaEntity;
import com.b1nd.alimoserver.domain.childCode.application.domain.model.ChildCode;
import com.b1nd.alimoserver.global.annotations.Mapper;

@Mapper
public class ChildCodeMapper {
    public ChildCode mapToDomainEntity(ChildCodeJpaEntity childCodeJpaEntity) {
        return ChildCode.withId(
                new ChildCode.ChildCodeId(childCodeJpaEntity.getChildCode()),
                childCodeJpaEntity.getCnt()
        );
    }

    public ChildCodeJpaEntity mapToJpaEntity(ChildCode childCode) {
        return ChildCodeJpaEntity.builder()
                .childCode(childCode.childCode().value())
                .cnt(childCode.cnt())
                .build();
    }


}
