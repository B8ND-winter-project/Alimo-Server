package com.b1nd.alimoserver.domain.auth.application.domain.service;

import com.b1nd.alimoserver.domain.auth.adapter.in.api.dto.request.DAuthSignInRequest;
import com.b1nd.alimoserver.domain.auth.adapter.in.api.dto.request.SignInRequest;
import com.b1nd.alimoserver.domain.auth.adapter.in.api.dto.request.SignUpRequest;
import com.b1nd.alimoserver.domain.auth.application.port.in.SignInUseCase;
import com.b1nd.alimoserver.domain.auth.application.domain.model.Token;
import com.b1nd.alimoserver.domain.auth.application.port.in.SignUpUseCase;
import com.b1nd.alimoserver.domain.member.adapter.out.persistence.adapter.MemberLoadAdapter;
import com.b1nd.alimoserver.domain.member.application.domain.model.Member;
import com.b1nd.alimoserver.domain.member.application.port.in.CommandMemberPort;
import com.b1nd.alimoserver.domain.member.application.port.out.LoadMemberPort;
import com.b1nd.alimoserver.global.annotations.UseCase;
import com.b1nd.alimoserver.global.infra.DAuth.port.out.ProvideDodamTokenPort;
import com.b1nd.alimoserver.global.infra.jwt.port.out.ProvideJwtTokenPort;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class AuthService implements SignInUseCase, SignUpUseCase {
    private final ProvideDodamTokenPort provideDodamTokenPort;
    private final ProvideJwtTokenPort provideJwtTokenPort;
    private final CommandMemberPort commandMemberPort;
    private final LoadMemberPort loadMemberPort;

    @Override
    public Token dAuthSignIn(DAuthSignInRequest request) {
        final Token token = provideDodamTokenPort.generateToken(request);
        commandMemberPort.createOrUpdateMemberWithDAuth(token.accessToken());

        return token;
    }

    @Override
    public Token signIn(SignInRequest request) {
        Member member = (loadMemberPort.loadMemberByEmail(request.email()));
        return provideJwtTokenPort.generateToken(member.memberId().value());
    }

    @Override
    public Token signUp(SignUpRequest request) {
        Member member = commandMemberPort.createParentMember(request);
        return provideJwtTokenPort.generateToken(member.memberId().value());
    }
}
