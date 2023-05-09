package com.logger.web.service;

import com.logger.web.model.dto.request.UserSaveRequest;
import com.logger.web.model.entity.UserEntity;

public interface UserService {
    UserEntity save(UserSaveRequest userSaveRequest);

    String delete(String userId);

    UserEntity get(String userId);

}
