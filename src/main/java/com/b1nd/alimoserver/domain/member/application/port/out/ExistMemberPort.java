package com.b1nd.alimoserver.domain.member.application.port.out;

public interface ExistMemberPort {
    Boolean existByEmail(String Email);
}
