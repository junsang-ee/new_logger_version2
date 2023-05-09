package com.logger.web.model.entity;

import com.logger.web.model.entity.common.CustomBaseIdEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "attach")
public class AttachEntity extends CustomBaseIdEntity {
    private String groupId;

    private String originName;

    private String targetName;

    private long size;

    private String contentType;

    private String path;

}
