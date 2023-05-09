package com.logger.web.service;


import com.logger.web.model.dto.request.UserSaveRequest;
import com.logger.web.model.entity.ServiceProviderEntity;
import com.logger.web.model.entity.UserEntity;
import com.logger.web.repository.ServiceProviderRepository;
import com.logger.web.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ServiceProviderRepository serviceProviderRepository;


    @Transactional
    @Override
    public UserEntity save(UserSaveRequest userSaveRequest) {
        log.info("service userSaveRequest getEmail :: " + userSaveRequest.getEmail());
        return userRepository.save(toSaveEntity(userSaveRequest));
    }

    @Transactional
    @Override
    public String delete(String userId) {
        get(userId);
        userRepository.deleteById(userId);
        return "Success " + userId + " user";
    }

    @Override
    public UserEntity get(String userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("not found user")
        );
    }


    private UserEntity toSaveEntity(UserSaveRequest userSaveRequest) {
        UserEntity user = new UserEntity();
        user.setEmail(userSaveRequest.getEmail());
        user.setName(userSaveRequest.getName());
        user.setRole(UserEntity.Role.OWNER);
        user.setType(UserEntity.Type.ADMIN);
        user.setMobile(userSaveRequest.getMobile());
        user.setPassword(userSaveRequest.getPassword());
        user.setServiceProvider(saveServiceProvider());
        return user;
    }

    @Transactional
    public ServiceProviderEntity saveServiceProvider() {
        ServiceProviderEntity serviceProvider = new ServiceProviderEntity();
        String code = String.valueOf(UUID.randomUUID());
        serviceProvider.setCode(code);
        return serviceProviderRepository.save(serviceProvider);
    }


}
