package com.logger.web.controller;


import com.logger.web.model.dto.request.AttachSaveRequest;
import com.logger.web.service.AttachService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/attach")
@RestController
public class AttachController {

    private final AttachService attachService;

    @PostMapping
    public String save(AttachSaveRequest attachSaveRequest) {
        return attachService.save(attachSaveRequest).getGroupId();
    }

}
