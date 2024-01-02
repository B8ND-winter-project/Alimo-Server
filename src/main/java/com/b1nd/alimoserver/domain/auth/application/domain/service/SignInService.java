package com.b1nd.alimoserver.domain.auth.application.domain.service;

import com.b1nd.alimoserver.domain.auth.adapter.in.api.dto.request.SignInRequest;
import com.b1nd.alimoserver.domain.auth.application.port.in.SignInUseCase;
import com.b1nd.alimoserver.domain.auth.application.domain.model.Token;
import com.b1nd.alimoserver.domain.member.application.port.in.CommandMemberPort;
import com.b1nd.alimoserver.global.annotations.UseCase;
import com.b1nd.alimoserver.global.infra.DAuth.port.out.ProvideDodamTokenPort;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class SignInService implements SignInUseCase {
    private final ProvideDodamTokenPort provideDodamTokenPort;
    private final CommandMemberPort createOrUpdateMemberPort;

    @Override
    public Token signIn(SignInRequest request) {
        final Token token = provideDodamTokenPort.generateToken(request);
        createOrUpdateMemberPort.createOrUpdateMember(token.accessToken());

        return token;
    }
}
