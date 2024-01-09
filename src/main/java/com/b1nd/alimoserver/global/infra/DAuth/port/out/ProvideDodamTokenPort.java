package com.b1nd.alimoserver.global.infra.DAuth.port.out;

import com.b1nd.alimoserver.domain.auth.adapter.in.api.dto.request.DAuthSignInRequest;
import com.b1nd.alimoserver.domain.auth.application.domain.model.Token;

public interface ProvideDodamTokenPort {
    Token generateToken(DAuthSignInRequest request);
}
