package tn.iit.project_search_tun.service;

import tn.iit.project_search_tun.entity.project_request.ProjectRequestStatus;

public interface ProjectRequestService {
    ProjectRequestStatus acceptOrRejectProjectRequest(int projectRequestId, ProjectRequestStatus status);
}
