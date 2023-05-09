package com.logger.web.service;

import com.logger.web.model.dto.request.AttachSaveRequest;
import com.logger.web.model.entity.AttachEntity;

public interface AttachService {
    AttachEntity save(AttachSaveRequest attachSaveRequest);
}
