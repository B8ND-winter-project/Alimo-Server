package com.b1nd.alimoserver.global.infra.jwt.port.out;

import com.b1nd.alimoserver.domain.auth.application.domain.model.Token;

public interface ProvideJwtTokenPort {
    Token generateToken(Long id);
    String generateAccessToken(Long id);
    String generateRefreshToken(Long id);
}
