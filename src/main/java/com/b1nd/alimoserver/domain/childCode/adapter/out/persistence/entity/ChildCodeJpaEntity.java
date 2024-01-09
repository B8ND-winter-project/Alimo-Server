package com.b1nd.alimoserver.domain.childCode.adapter.out.persistence.entity;

import com.b1nd.alimoserver.domain.member.adapter.out.persistence.entity.MemberJpaEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "tbl_childCode")
@DynamicUpdate
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChildCodeJpaEntity {
    @Id
    private String childCode;

    private String childName;

    private int cnt = 0;

    @OneToMany(mappedBy = "childCode")
    private List<MemberJpaEntity> members = new ArrayList<>();

}
