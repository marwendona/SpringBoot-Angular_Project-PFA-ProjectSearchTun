package com.API_User.API_User.service;

import com.API_User.API_User.entity.project_request.ProjectRequestStatus;

public interface ProjectRequestService {
    ProjectRequestStatus acceptOrRejectProjectRequest(int projectRequestId, ProjectRequestStatus status);
}
