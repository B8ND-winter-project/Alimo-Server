package com.b1nd.alimoserver.domain.member.application.port.out;

import com.b1nd.alimoserver.domain.member.application.domain.model.Member;

public interface GetCurrentMemberPort {

    Member getMember();

    Long getMemberId();

}