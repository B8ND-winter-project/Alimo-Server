package com.b1nd.alimoserver.domain.auth.application.domain.model;

import lombok.Builder;

@Builder
public record Token(
        String accessToken,
        String refreshToken
){}
