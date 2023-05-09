package com.logger.web.model.dto.request;

import com.logger.web.model.entity.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSaveRequest {
    private String name;

    private String email;

    private String password;

    private String mobile;

    private UserEntity.Role role;

    private UserEntity.Type type;

}
