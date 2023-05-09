package com.logger.web.model.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AttachSaveRequest {
    private String groupId;

    private String originName;

    private String targetName;

    private long size;

    private String contentType;

    private String path;
}
