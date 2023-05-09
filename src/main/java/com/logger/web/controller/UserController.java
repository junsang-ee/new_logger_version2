package com.logger.web.controller;

import com.logger.web.model.dto.request.UserSaveRequest;
import com.logger.web.model.entity.UserEntity;
import com.logger.web.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/user")
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserEntity save(@RequestBody UserSaveRequest userSaveRequest) {
        return userService.save(userSaveRequest);
    }

    @DeleteMapping("/{userId}")
    public String delete(@PathVariable String userId) {
        return userService.delete(userId);
    }

}
