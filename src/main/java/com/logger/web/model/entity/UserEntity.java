package com.logger.web.model.entity;

import com.logger.web.model.entity.common.CustomBaseIdEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@DynamicInsert
@Entity(name = "user")
public class UserEntity extends CustomBaseIdEntity implements Serializable {
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


//    @OneToOne(cascade = CascadeType.PERSIST)
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "service_provider")
    private ServiceProviderEntity serviceProvider;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "profile")
    private AttachEntity profile;

    public enum Role {
        OWNER, MEMBER
    }

    public enum Type {
        ADMIN, USER
    }

    public enum Status {
        PENDING, ENABLED, DISABLED
    }

    @OneToMany(mappedBy = "createdBy")
    private List<PostEntity> posts;

    @PrePersist
    private void onPrePersist() {
        this.status = Status.ENABLED;
    }

}
