package com.API_User.API_User.controller;

import com.API_User.API_User.entity.project.Project;
import com.API_User.API_User.repository.ProjectRepository;
import com.API_User.API_User.repository.UserRepository;
import com.API_User.API_User.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/projects")
@Validated
public class ProjectController {
    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;
    private final ProjectService projectService;

    @Autowired
    public ProjectController(UserRepository userRepository, ProjectRepository projectRepository, ProjectService projectService) {
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
        this.projectService = projectService;
    }

//    @GetMapping
//    public List<ProjectDto> getProjects() {
//        return projectRepository.findAll()
//                .stream()
//                //.map(AuctionAdapter::toAuctionDetails)
//                .toList();
//    }

//    @GetMapping
//    public List<ProjectDto> getAllProjects() {
//        return projectService.getAllProjects();
//    }

//    @GetMapping
//    public List<Project> getAllProjects() {
//
//        List<Project> allBids = projectService.getAllProjects()
//                .stream()
//                .map(bidDto -> Project.builder().projectId(projectService))
//                .toList();
//        return allBids;
//    }

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

}

