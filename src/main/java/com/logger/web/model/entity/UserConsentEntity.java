package com.logger.web.model.entity;

import com.logger.web.model.entity.common.CustomBaseIdEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "user_consent")
public class UserConsentEntity extends CustomBaseIdEntity {

    @Enumerated(EnumType.STRING)
    private Type type;

    @Enumerated(EnumType.STRING)
    private Consent consent;

    @ManyToOne
    @JoinColumn(name = "user")
    private UserEntity user;


    public enum Type {
        NIGHT, EVENT
    }

    public enum Consent {
        CONSENT, DISSENT
    }
}
