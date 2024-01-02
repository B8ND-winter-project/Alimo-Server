package com.b1nd.alimoserver.domain.member.application.port.in;

public interface CommandMemberPort {
    void createOrUpdateMember(String accessToken);
}
