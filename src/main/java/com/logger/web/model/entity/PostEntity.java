package com.logger.web.model.entity;

import com.logger.web.model.entity.common.CreationLocalDateTimeEntity;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Setter
@NoArgsConstructor
@Entity(name = "post")
public class PostEntity extends CreationLocalDateTimeEntity {
    private String title;

    private String body;

    private Type type;

    private String groupId;

    private enum Type {
        NOTICE, QNA, FAQ, INSPECT, SALES
    }
}
