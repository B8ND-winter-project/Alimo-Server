package com.b1nd.alimoserver.domain.file.adapter.out.persistence.entity;

import com.b1nd.alimoserver.domain.file.application.domain.model.enums.FileType;
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
@Table(name = "tbl_file")
@DynamicUpdate
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FileJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileId;

    @Column(columnDefinition = "TEXT")
    private String fileUrl;

    @Size(max=100)
    private String fileName;

    @Size(max=10)
    @Enumerated(EnumType.STRING)
    private FileType fileType;
}