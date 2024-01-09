package com.b1nd.alimoserver.domain.member.adapter.out.persistence.adapter;

import com.b1nd.alimoserver.domain.auth.adapter.in.api.dto.request.SignUpRequest;
import com.b1nd.alimoserver.domain.auth.application.domain.model.Token;
import com.b1nd.alimoserver.domain.childCode.adapter.out.persistence.ChildCodeMapper;
import com.b1nd.alimoserver.domain.childCode.adapter.out.persistence.adapter.ChildCodeLoadAdapter;
import com.b1nd.alimoserver.domain.childCode.adapter.out.persistence.entity.ChildCodeJpaEntity;
import com.b1nd.alimoserver.domain.member.adapter.out.persistence.MemberJpaRepository;
import com.b1nd.alimoserver.domain.member.adapter.out.persistence.MemberMapper;
import com.b1nd.alimoserver.domain.member.adapter.out.persistence.entity.MemberJpaEntity;
import com.b1nd.alimoserver.domain.member.application.domain.consts.MemberRole;
import com.b1nd.alimoserver.domain.childCode.application.domain.model.ChildCode;
import com.b1nd.alimoserver.domain.member.application.domain.model.Member;
import com.b1nd.alimoserver.domain.member.application.port.in.CommandMemberPort;
import com.b1nd.alimoserver.global.annotations.PersistenceAdapter;
import com.b1nd.alimoserver.global.infra.random.RandomGenerator;
import com.b1nd.dauth.DAuth;
import com.b1nd.dauth.client.response.DAuthUserInfo;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class MemberPersistenceAdapter implements CommandMemberPort {
    private final DAuth dAuth;
    private final MemberJpaRepository memberJpaRepository;
    private final MemberMapper memberMapper;
    private final ChildCodeMapper childCodeMapper;
    private final MemberLoadAdapter memberLoadAdapter;
    private final ChildCodeLoadAdapter childCodeLoadAdapter;

    @Override
    public void createOrUpdateMemberWithDAuth(String accessToken) {
        final DAuthUserInfo userInfo = dAuth.getUser(accessToken);

        if (!memberJpaRepository.existsByEmail(userInfo.getUser().getEmail())){
            memberJpaRepository.save(memberMapper.mapToJpaEntityWithDAuth(userInfo.getUser(),RandomGenerator.generate()));
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

    @Override
    public Member createParentMember(SignUpRequest request) {
        // 기존의 ChildCode를 데이터베이스에서 조회
        ChildCode.ChildCodeId childCodeId = new ChildCode.ChildCodeId(request.childCode());
        ChildCodeJpaEntity childCodeJpaEntity = childCodeLoadAdapter.loadChildCodeJpaEntity(childCodeId.value());
        ChildCode existingChildCode = childCodeMapper.mapToDomainEntity(childCodeJpaEntity);

        // 새로운 Member 객체 생성 (기존 ChildCode와 연관관계 맺음)
        Member newMember = Member.withId(
                null, // DB에서 자동 생성될 것으로 예상되는 MemberId는 여기서 넘기지 않음
                request.email(),
                request.password(),
                null,
                null, // Grade 정보는 SignUpRequest에서 가져오지 않음
                request.fcmToken(),
                MemberRole.MEMBER,
                existingChildCode // 기존 ChildCode와 연관관계 맺음
        );

        // Member 객체를 JPA 엔티티로 변환하여 저장
        MemberJpaEntity memberJpaEntity = memberJpaRepository.save(memberMapper.mapToJpaEntity(newMember));

        memberJpaEntity.settingParentName(memberJpaEntity.getChildCode().getChildName()+"부모님");

        return memberMapper.mapToDomainEntity(memberJpaEntity);
    }
}
