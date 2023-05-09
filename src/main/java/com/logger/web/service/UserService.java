package com.logger.web.service;

import com.logger.web.model.dto.request.UserSaveRequest;
import com.logger.web.model.entity.UserEntity;

public interface UserService {
    public UserEntity save(UserSaveRequest userSaveRequest);
}
