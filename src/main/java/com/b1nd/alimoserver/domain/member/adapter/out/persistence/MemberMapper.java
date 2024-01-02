package com.b1nd.alimoserver.domain.member.adapter.out.persistence;

import com.b1nd.alimoserver.domain.member.adapter.out.persistence.entity.MemberJpaEntity;
import com.b1nd.alimoserver.domain.member.application.domain.model.Member;
import com.b1nd.alimoserver.global.annotations.Mapper;
import com.b1nd.dauth.client.response.DAuthUser;

@Mapper
public class MemberMapper {
    public Member mapToDomainEntity(MemberJpaEntity member) {
        return Member.withId(
                new Member.MemberId(member.getMemberId()),
                member.getName(),
                member.getPassword(),
                member.getEmail(),
                member.getGrade(),
                member.getFcmToken()
                );
    }

    public MemberJpaEntity mapToJpaEntity(Member member) {
        return MemberJpaEntity.builder()
                .memberId(member.memberId().getValue())
                .name(member.name())
                .password(member.password())
                .email(member.email())
                .grade(member.grade())
                .fcmToken(member.fcmToken())
                .build();
    }

    public MemberJpaEntity mapToJpaEntityWithDAuth(DAuthUser member) {
        return MemberJpaEntity.builder()
                .name(member.getName())
                .email(member.getEmail())
                .grade(Long.valueOf(member.getGrade()))
                .build();
    }
}
