package com.logger.web.service;


import com.logger.web.model.dto.request.UserSaveRequest;
import com.logger.web.model.entity.ServiceProviderEntity;
import com.logger.web.model.entity.UserEntity;
import com.logger.web.repository.ServiceProviderRepository;
import com.logger.web.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private ServiceProviderRepository serviceProviderRepository;

    @Override
    public UserEntity save(UserSaveRequest userSaveRequest) {
        return userRepository.save(toSaveEntity(userSaveRequest));
    }

    private UserEntity toSaveEntity(UserSaveRequest userSaveRequest) {
        UserEntity user = new UserEntity();
        user.setEmail(userSaveRequest.getEmail());
        user.setName(userSaveRequest.getName());
        user.setRole(userSaveRequest.getRole());
        user.setType(userSaveRequest.getType());
        user.setMobile(userSaveRequest.getMobile());
        user.setPassword(userSaveRequest.getPassword());
        user.setServiceProvider(saveServiceProvider());
        return user;
    }

    private ServiceProviderEntity saveServiceProvider() {
        ServiceProviderEntity serviceProvider = new ServiceProviderEntity();
        String randomServiceCode = String.valueOf(UUID.randomUUID());
        serviceProvider.setServiceCode(randomServiceCode);
        return serviceProviderRepository.save(serviceProvider);
    }

}
