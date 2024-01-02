package com.b1nd.alimoserver.global.infra.DAuth.adapter;

import com.b1nd.alimoserver.domain.auth.adapter.in.api.dto.request.SignInRequest;
import com.b1nd.alimoserver.domain.auth.application.domain.model.Token;
import com.b1nd.alimoserver.global.annotations.PersistenceAdapter;
import com.b1nd.alimoserver.global.infra.DAuth.port.out.ProvideDodamTokenPort;
import com.b1nd.dauth.DAuth;
import com.b1nd.dauth.client.response.DAuthTokenInfo;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class DAuthAdapter implements ProvideDodamTokenPort {
    private final DAuth dAuth;

    @Override
    public Token generateToken(SignInRequest request) {
        final DAuthTokenInfo dAuthTokenInfo = dAuth.issueToken(request.code());
        return Token.builder()
                .accessToken(dAuthTokenInfo.getAccessToken())
                .refreshToken(dAuthTokenInfo.getRefreshToken())
                .build();
    }
}
