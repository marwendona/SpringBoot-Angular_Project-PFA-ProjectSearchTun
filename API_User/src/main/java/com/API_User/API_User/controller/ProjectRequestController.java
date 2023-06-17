package com.API_User.API_User.controller;

import com.API_User.API_User.entity.project_request.ProjectRequestStatus;
import com.API_User.API_User.entity.project_request.StatusWrapper;
import com.API_User.API_User.repository.ProjectRepository;
import com.API_User.API_User.repository.ProjectRequestRepository;
import com.API_User.API_User.repository.UserRepository;
import com.API_User.API_User.service.ProjectRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/projects_requests")
@Validated
public class ProjectRequestController {
    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;
    private final ProjectRequestRepository projectRequestRepository;
    private final ProjectRequestService projectRequestService;

    @Autowired
    public ProjectRequestController(UserRepository userRepository, ProjectRepository projectRepository, ProjectRequestRepository projectRequestRepository, ProjectRequestService projectRequestService) {
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
        this.projectRequestRepository = projectRequestRepository;
        this.projectRequestService = projectRequestService;
    }

    @PutMapping("/{projectRequestId}/status")
    public ProjectRequestStatus acceptOrRejectProjectRequest(@PathVariable int projectRequestId, @RequestBody StatusWrapper statusWrapper) {
        return projectRequestService.acceptOrRejectProjectRequest(projectRequestId, statusWrapper.getStatus());
    }
}
