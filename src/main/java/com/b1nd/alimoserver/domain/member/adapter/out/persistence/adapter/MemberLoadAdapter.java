package com.b1nd.alimoserver.domain.member.adapter.out.persistence.adapter;

import com.b1nd.alimoserver.domain.member.adapter.out.persistence.MemberJpaRepository;
import com.b1nd.alimoserver.domain.member.adapter.out.persistence.entity.MemberJpaEntity;
import com.b1nd.alimoserver.global.annotations.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class MemberLoadAdapter {
    private final MemberJpaRepository memberRepository;
    public MemberJpaEntity loadMemberJpaEntityWithEmail(String email) {
        return memberRepository.findByEmail(email).get();
    }
}
