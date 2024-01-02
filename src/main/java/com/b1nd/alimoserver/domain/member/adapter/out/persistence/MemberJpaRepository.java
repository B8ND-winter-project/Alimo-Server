package com.b1nd.alimoserver.domain.member.adapter.out.persistence;

import com.b1nd.alimoserver.domain.member.adapter.out.persistence.entity.MemberJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberJpaRepository extends JpaRepository<MemberJpaEntity,Long> {
    Boolean existsByEmail(String email);
    Optional<MemberJpaEntity> findByEmail(String email);
}
