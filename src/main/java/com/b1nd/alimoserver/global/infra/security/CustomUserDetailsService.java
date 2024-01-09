package com.b1nd.alimoserver.global.infra.security;

import com.b1nd.alimoserver.domain.member.adapter.out.persistence.MemberJpaRepository;
import com.b1nd.alimoserver.domain.member.adapter.out.persistence.MemberMapper;
import com.b1nd.alimoserver.domain.member.adapter.out.persistence.adapter.MemberLoadAdapter;
import com.b1nd.alimoserver.domain.member.application.domain.model.Member;
import com.b1nd.alimoserver.global.error.custom.user.MemberNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberLoadAdapter memberLoadAdapter;
    private final MemberMapper memberMapper;

    @Override
    public UserDetails loadUserByUsername(String email) {

        Member member = memberMapper.mapToDomainEntity(memberLoadAdapter.loadMemberJpaEntityWithEmail(email));

        return new CustomUserDetails(member);
    }
}
