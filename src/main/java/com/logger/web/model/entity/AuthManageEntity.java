package com.logger.web.model.entity;

import com.logger.web.model.entity.common.CustomBaseIdEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "auth_manage")
public class AuthManageEntity extends CustomBaseIdEntity {
    private String token;

    @Enumerated(EnumType.STRING)
    private Type type;

    private LocalDateTime expireAt;

    private LocalDateTime loginAt;

    private String userAgent;

    private String updatePassword;

    @OneToOne
    @JoinColumn(name = "user")
    private UserEntity user;

    public enum Type {
        BRROWSER, APP
    }
}
