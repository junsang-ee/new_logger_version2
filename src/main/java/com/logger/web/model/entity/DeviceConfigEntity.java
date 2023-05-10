package com.logger.web.model.entity;

import com.logger.web.model.entity.common.CustomBaseIdEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name = "device_config")
public class DeviceConfigEntity extends CustomBaseIdEntity {

    @Enumerated(EnumType.STRING)
    private Type type;

    @Enumerated(EnumType.STRING)
    private Scope scope;

    private int value;

    private int min;

    private int max;

    @ManyToOne
    @JoinColumn(name = "user")
    private UserEntity user;

    public enum Type {
        TEMPERATURE, HUMIDITY, GRAVITY, CRASH, PERIOD, PRECONDITION
    }

    public enum Scope {
        RANGE, STANDARD
    }
}
