package com.b1nd.alimoserver.domain.member.adapter.out.persistence.adapter;

import com.b1nd.alimoserver.domain.member.adapter.out.persistence.MemberJpaRepository;
import com.b1nd.alimoserver.domain.member.adapter.out.persistence.MemberMapper;
import com.b1nd.alimoserver.domain.member.adapter.out.persistence.entity.MemberJpaEntity;
import com.b1nd.alimoserver.domain.member.application.domain.model.Member;
import com.b1nd.alimoserver.domain.member.application.port.in.CommandMemberPort;
import com.b1nd.dauth.DAuth;
import com.b1nd.dauth.client.response.DAuthUserInfo;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MemberPersistenceAdapter implements CommandMemberPort {
    private final DAuth dAuth;
    private final MemberJpaRepository memberJpaRepository;
    private final MemberMapper memberMapper;
    private final MemberLoadAdapter memberLoadAdapter;

    @Override
    public void createOrUpdateMember(String accessToken) {
        final DAuthUserInfo userInfo = dAuth.getUser(accessToken);

        if (!memberJpaRepository.existsByEmail(userInfo.getUser().getEmail())){
            memberJpaRepository.save(memberMapper.mapToJpaEntityWithDAuth(userInfo.getUser()));
        }else{
            MemberJpaEntity memberJpaEntity = memberLoadAdapter.loadMemberJpaEntityWithEmail(userInfo.getUser().getEmail());
            Member member = memberMapper.mapToDomainEntity(memberJpaEntity);

            memberJpaEntity.updateMemberInfo(
                    member.email(),
                    member.grade(),
                    member.name()
            );
        }
    }
}
