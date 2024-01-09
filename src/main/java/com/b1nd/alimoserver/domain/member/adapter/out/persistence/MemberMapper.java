package com.b1nd.alimoserver.domain.member.adapter.out.persistence;

import com.b1nd.alimoserver.domain.childCode.adapter.out.persistence.ChildCodeMapper;
import com.b1nd.alimoserver.domain.childCode.adapter.out.persistence.entity.ChildCodeJpaEntity;
import com.b1nd.alimoserver.domain.member.adapter.out.persistence.entity.MemberJpaEntity;
import com.b1nd.alimoserver.domain.member.application.domain.model.Member;
import com.b1nd.alimoserver.global.annotations.Mapper;
import com.b1nd.dauth.client.response.DAuthUser;
import lombok.RequiredArgsConstructor;

@Mapper
@RequiredArgsConstructor
public class MemberMapper {
    private final ChildCodeMapper childCodeMapper;

    public Member mapToDomainEntity(MemberJpaEntity memberJpaEntity) {
        return Member.withId(
                new Member.MemberId(memberJpaEntity.getMemberId()),
                memberJpaEntity.getName(),
                memberJpaEntity.getPassword(),
                memberJpaEntity.getEmail(),
                memberJpaEntity.getGrade(),
                memberJpaEntity.getFcmToken(),
                memberJpaEntity.getRole(),
                childCodeMapper.mapToDomainEntity(memberJpaEntity.getChildCode())
        );
    }

    public MemberJpaEntity mapToJpaEntity(Member member) {
        return MemberJpaEntity.builder()
                .memberId(member.memberId().value())
                .name(member.name())
                .password(member.password())
                .email(member.email())
                .grade(member.grade())
                .fcmToken(member.fcmToken())
                .role(member.role())
                .childCode(childCodeMapper.mapToJpaEntity(member.childCode()))
                .build();
    }

    public MemberJpaEntity mapToJpaEntityWithDAuth(DAuthUser member, String childCode) {
        return MemberJpaEntity.builder()
                .name(member.getName())
                .email(member.getEmail())
                .grade(Long.valueOf(member.getGrade()))
                .childCode(
                        ChildCodeJpaEntity.builder()
                                .childCode(childCode)
                                .cnt(0)
                                .build()
                )
                .build();
    }
}
