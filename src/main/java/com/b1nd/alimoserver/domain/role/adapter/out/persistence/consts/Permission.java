package com.b1nd.alimoserver.domain.role.adapter.out.persistence.consts;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "tbl_permission")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long permissionId;

    private String description;
}
