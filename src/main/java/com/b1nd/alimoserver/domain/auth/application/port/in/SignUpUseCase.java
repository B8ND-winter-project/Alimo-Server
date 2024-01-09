package com.b1nd.alimoserver.domain.auth.application.port.in;

import com.b1nd.alimoserver.domain.auth.adapter.in.api.dto.request.SignUpRequest;
import com.b1nd.alimoserver.domain.auth.application.domain.model.Token;

public interface SignUpUseCase {
    Token signUp(SignUpRequest request);
}
