package com.logger.web.model.entity;

import com.logger.web.model.entity.common.CustomBaseIdEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "user_consent")
public class UserConsentEntity extends CustomBaseIdEntity {

    private Type type;

    @ManyToOne
    @JoinColumn(name = "user")
    private UserEntity user;

    private Consent consent;

    private enum Type {
        NIGHT, EVENT
    }

    private enum Consent {
        CONSENT, DISSENT
    }
}
