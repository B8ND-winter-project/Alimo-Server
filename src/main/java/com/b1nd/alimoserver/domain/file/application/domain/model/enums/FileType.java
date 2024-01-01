package com.b1nd.alimoserver.domain.file.application.domain.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FileType {
    IMAGE("FILE_IMAGE"),
    HWP("FILE_HWP"),
    PDF("FILE_PDF"),
    EXCEL("FILE_EXCEL"),
    WORD("FILE_WORD"),
    PPT("FILE_PPT"),;

    private final String key;
}
