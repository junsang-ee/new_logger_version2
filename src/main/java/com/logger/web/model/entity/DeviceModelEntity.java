package com.logger.web.model.entity;


import com.logger.web.model.entity.common.CustomBaseIdEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "device_model")
public class DeviceModelEntity extends CustomBaseIdEntity {
    private String name;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Enumerated(EnumType.STRING)
    private Feature feature;

    private String description;

    private String attachGroupId;
    public enum Feature {
        NFC, BLE, PROBE, LTE, EPAPER, WIFI
    }

    public enum Type {
        LOGGER, EPD, GATEWAY
    }


}
