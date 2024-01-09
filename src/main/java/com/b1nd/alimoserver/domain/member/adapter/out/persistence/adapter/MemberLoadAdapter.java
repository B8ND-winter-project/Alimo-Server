package com.b1nd.alimoserver.domain.member.adapter.out.persistence.adapter;

import com.b1nd.alimoserver.domain.member.adapter.out.persistence.MemberJpaRepository;
import com.b1nd.alimoserver.domain.member.adapter.out.persistence.MemberMapper;
import com.b1nd.alimoserver.domain.member.adapter.out.persistence.entity.MemberJpaEntity;
import com.b1nd.alimoserver.domain.member.application.domain.model.Member;
import com.b1nd.alimoserver.domain.member.application.port.out.LoadMemberPort;
import com.b1nd.alimoserver.global.annotations.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class MemberLoadAdapter implements LoadMemberPort {
    private final MemberJpaRepository memberRepository;
    private final MemberMapper memberMapper;

    public MemberJpaEntity loadMemberJpaEntityWithEmail(String email) {
        return memberRepository.findByEmail(email).get();
    }

    @Override
    public Member loadMemberByEmail(String email) {
        return memberMapper.mapToDomainEntity(memberRepository.findByEmail(email).get());
    }
}
