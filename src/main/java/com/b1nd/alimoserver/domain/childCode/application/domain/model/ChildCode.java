package com.b1nd.alimoserver.domain.childCode.application.domain.model;

import com.b1nd.alimoserver.domain.member.application.domain.model.Member;

import java.util.Objects;

public record ChildCode(
        ChildCodeId childCode,
        String ChildName,
        int cnt,
        Member member
) {

    public record ChildCodeId(String value) {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ChildCode.ChildCodeId childCodeId = (ChildCode.ChildCodeId) o;
            return Objects.equals(value, childCodeId.value);
        }
    }

    public static ChildCode withId(
            ChildCode.ChildCodeId childCodeId,
            String childName,
            int cnt,
            Member member
            ) {
        return new ChildCode(childCodeId, childName,cnt,member);
    }
}
