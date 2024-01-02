package com.b1nd.alimoserver.domain.auth.application.port.in;

import com.b1nd.alimoserver.domain.auth.adapter.in.api.dto.request.SignInRequest;
import com.b1nd.alimoserver.domain.auth.application.domain.model.Token;

public interface SignInUseCase {
    Token signIn(SignInRequest request);
}
