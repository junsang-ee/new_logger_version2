package com.logger.web.model.entity;

import com.logger.web.model.CustomBaseIdEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "user")
public class UserEntity extends CustomBaseIdEntity {
    private String name;

    private String email;

    private String password;

    private String mobile;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Enumerated(EnumType.STRING)
    private Status status;


    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "service_provider")
    private ServiceProviderEntity serviceProvider;

    public enum Role {
        OWNER, MEMBER
    }

    public enum Type {
        ADMIN, USER
    }

    public enum Status {
        PENDING, ENABLED, DISABLED
    }

    @PrePersist
    private void onPrePersist() {
        this.status = Status.ENABLED;
    }
}
