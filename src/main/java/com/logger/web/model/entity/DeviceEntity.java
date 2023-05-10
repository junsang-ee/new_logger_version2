package com.logger.web.model.entity;

import com.logger.web.model.entity.common.CustomBaseIdEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name = "device")
public class DeviceEntity extends CustomBaseIdEntity {
    private String name;

    private int serialNumber;

    private String macAddress;

    private int battery;

    private double firmwareVersion;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "user")
    private UserEntity user;

    @OneToOne
    @JoinColumn(name = "serviceProvider")
    private ServiceProviderEntity serviceProvider;

    @OneToOne
    @JoinColumn(name = "deviceModel")
    private DeviceModelEntity deviceModel;

    public enum Status {
        ACTIVATE, DEACTIVATE
    }

}
