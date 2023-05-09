package com.logger.web.service;

import com.logger.web.model.dto.request.AttachSaveRequest;
import com.logger.web.model.entity.AttachEntity;
import com.logger.web.repository.AttachRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AttachServiceImpl implements AttachService{

    private final AttachRepository attachRepository;

    @Override
    public AttachEntity save(AttachSaveRequest attachSaveRequest) {
        return attachRepository.save(toEntity(attachSaveRequest));
    }

    private AttachEntity toEntity(AttachSaveRequest attachSaveRequest) {
        AttachEntity result = new AttachEntity();
        result.setSize(attachSaveRequest.getSize());
        result.setPath(attachSaveRequest.getPath());
        result.setContentType(attachSaveRequest.getContentType());
        result.setTargetName(attachSaveRequest.getTargetName());
        result.setOriginName(attachSaveRequest.getOriginName());
        result.setGroupId(attachSaveRequest.getGroupId() == null ?
                        String.valueOf(UUID.randomUUID()) :
                        attachSaveRequest.getGroupId());
        return result;
    }


}
