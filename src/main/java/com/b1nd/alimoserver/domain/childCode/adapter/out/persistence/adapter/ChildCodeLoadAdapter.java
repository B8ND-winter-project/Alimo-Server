package com.b1nd.alimoserver.domain.childCode.adapter.out.persistence.adapter;

import com.b1nd.alimoserver.domain.childCode.adapter.out.persistence.ChildCodeJpaRepository;
import com.b1nd.alimoserver.domain.childCode.adapter.out.persistence.entity.ChildCodeJpaEntity;
import com.b1nd.alimoserver.global.annotations.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class ChildCodeLoadAdapter{
    private final ChildCodeJpaRepository childCodeJpaRepository;
    public ChildCodeJpaEntity loadChildCodeJpaEntity(String childCode) {
        return childCodeJpaRepository.findById(childCode).get();
    }
}
