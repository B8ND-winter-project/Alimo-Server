package com.b1nd.alimoserver.domain.member.adapter.out.persistence.adapter;

import com.b1nd.alimoserver.domain.member.application.domain.model.Member;
import com.b1nd.alimoserver.domain.member.application.port.out.GetCurrentMemberPort;

public class GetCurrentMemberAdapter implements GetCurrentMemberPort {
    @Override
    public Member getMember() {
        return null;
    }

    @Override
    public Long getMemberId() {
        return null;
    }
}
