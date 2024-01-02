package com.b1nd.alimoserver.domain.member.application.domain.model;

import lombok.Value;

import java.util.Objects;

public record Member(
        MemberId memberId,
        String email,
        Long grade,
        String name,
        String fcmToken,
        String password
) {

    @Value
    public record MemberId(Long value) {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MemberId memberId = (MemberId) o;
            return Objects.equals(value, memberId.value);
        }
    }

    public static Member withId(
            MemberId memberId,
            String email,
            String password,
            String name,
            Long grade,
            String fcmToken) {
        return new Member(memberId,email,grade,name,fcmToken,password);
    }


    public Member updateDodamInfo(String email, Long grade, String name) {
        return new Member(this.memberId(), email, grade, name, this.fcmToken(), this.password());
    }
}