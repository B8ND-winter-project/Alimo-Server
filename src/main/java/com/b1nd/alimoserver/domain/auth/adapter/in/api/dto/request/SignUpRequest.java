package com.b1nd.alimoserver.domain.auth.adapter.in.api.dto.request;

public record SignUpRequest(
        String email,
        String password,
        String fcmToken,
        String childCode
) {
}
