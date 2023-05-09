package com.logger.web.model.entity;

import com.logger.web.model.CustomBaseIdEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "service_provider")
public class ServiceProviderEntity extends CustomBaseIdEntity {

    private String serviceCode;
}
