package com.b1nd.alimoserver.domain.notification.adapter.out.persistence.entity;

import com.b1nd.alimoserver.domain.notification.application.domain.model.enums.Emoji;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Getter
@Table(name = "tbl_reaction")
@DynamicUpdate
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReactionJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reactionId;

//    @Size(max=10)
    @Enumerated(EnumType.STRING)
    private Emoji emoji;
}