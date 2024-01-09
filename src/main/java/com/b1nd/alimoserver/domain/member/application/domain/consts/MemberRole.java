package com.b1nd.alimoserver.domain.member.application.domain.consts;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberRole {
    GUEST("ROLE_GUEST"),
    MEMBER("ROLE_MEMBER");
    private final String key;
}
