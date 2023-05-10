package com.logger.web.model.entity;

import com.logger.web.model.entity.common.CreationLocalDateTimeEntity;
import com.logger.web.model.entity.common.CustomBaseIdEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "device_calibration")
public class DeviceCalibrationEntity extends CustomBaseIdEntity {

    private String description;

    private Certification certification;

    private LocalDateTime calibratedAt;

    @OneToOne
    @JoinColumn(name = "device")
    private DeviceEntity device;

    public enum Certification {
        CERTIFIED, UNCERTIFIED
    }

}
