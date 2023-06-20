package tn.iit.project_search_tun.controller;

import tn.iit.project_search_tun.entity.project_request.ProjectRequestStatus;
import tn.iit.project_search_tun.entity.project_request.StatusWrapper;
import tn.iit.project_search_tun.repository.ProjectRepository;
import tn.iit.project_search_tun.repository.ProjectRequestRepository;
import tn.iit.project_search_tun.repository.UserRepository;
import tn.iit.project_search_tun.service.ProjectRequestService;
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
