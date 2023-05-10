package com.logger.web.model.entity;

import com.logger.web.model.entity.common.CreationLocalDateTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "post")
public class PostEntity extends CreationLocalDateTimeEntity {
    private String title;

    private String body;

    private Type type;

    private String groupId;

    @ManyToOne
    @JoinColumn(name = "user")
    private UserEntity createdBy;

    public enum Type {
        NOTICE, QNA, FAQ, INSPECT, SALES
    }
}
