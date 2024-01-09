package com.b1nd.alimoserver.domain.childCode.adapter.out.persistence;

import com.b1nd.alimoserver.domain.childCode.adapter.out.persistence.entity.ChildCodeJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildCodeJpaRepository extends JpaRepository<ChildCodeJpaEntity,String> {

}
