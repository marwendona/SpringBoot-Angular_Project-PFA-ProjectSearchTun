package com.API_User.API_User.controller;

import com.API_User.API_User.repository.ProjectRepository;
import com.API_User.API_User.repository.ProjectRequestRepository;
import com.API_User.API_User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/projects_requests")
@Validated
public class ProjectRequestController {
    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;
    private final ProjectRequestRepository projectRequestRepository;

    @Autowired
    public ProjectRequestController(UserRepository userRepository, ProjectRepository projectRepository, ProjectRequestRepository projectRequestRepository) {
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
        this.projectRequestRepository = projectRequestRepository;
    }
}
