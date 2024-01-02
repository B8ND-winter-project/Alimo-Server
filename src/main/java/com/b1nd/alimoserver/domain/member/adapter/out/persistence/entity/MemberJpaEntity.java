package com.b1nd.alimoserver.domain.member.adapter.out.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Getter
@Table(name = "tbl_member")
@DynamicUpdate
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Size(max =320)
    @NotNull
    private String email;

    private String password;

    private Long grade;

    @Size(max =10)
    @NotNull
    private String name;

    @Column(columnDefinition = "TEXT")
    private String fcmToken;

    public void updateMemberInfo(String email, Long grade, String name) {
        this.email = email;
        this.grade = grade;
        this.name = name;
    }
}