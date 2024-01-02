package com.b1nd.alimoserver.domain.auth.adapter.in.api.dto.request;

public record SignInRequest(
        String code,
        String fcmToken
) {
}
