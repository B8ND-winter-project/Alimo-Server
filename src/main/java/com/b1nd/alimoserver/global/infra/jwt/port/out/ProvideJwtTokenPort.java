package com.b1nd.alimoserver.global.infra.jwt.port.out;

public interface ProvideJwtTokenPort {
    String generateAccessToken(Long id);
    String generateRefreshToken(Long id);
}
