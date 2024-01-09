package com.b1nd.alimoserver.domain.member.application.port.in;

import com.b1nd.alimoserver.domain.auth.adapter.in.api.dto.request.SignUpRequest;
import com.b1nd.alimoserver.domain.member.application.domain.model.Member;

public interface CommandMemberPort {
    void createOrUpdateMemberWithDAuth(String accessToken);
    Member createParentMember(SignUpRequest request);
}
