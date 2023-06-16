package com.API_User.API_User.controller;

import com.API_User.API_User.dto.ProjectDto;
import com.API_User.API_User.entity.project.Project;
import com.API_User.API_User.entity.project_request.ProjectRequest;
import com.API_User.API_User.repository.ProjectRepository;
import com.API_User.API_User.repository.UserRepository;
import com.API_User.API_User.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
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

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{projectId}")
    public Project getProject(@PathVariable int projectId) {
        return projectService.getProject(projectId);
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<ProjectDto> updateProject(@PathVariable("projectId") int projectId, @RequestBody Project project) {
        projectService.updateProject(projectId, project);
        return new ResponseEntity<>(projectService.findProjectById(projectId), HttpStatus.OK);
    }

    @DeleteMapping("/{projectId}")
    public void deleteProject(@PathVariable int projectId) {
        projectService.deleteProject(projectId);
    }

    @PostMapping("/{projectId}/projects_requests")
    public int createProjectRequest(@PathVariable int projectId, @RequestBody ProjectRequest projectRequest) {
        return projectService.createProjectRequest(projectId, projectRequest);
    }

    @GetMapping("{projectId}/projects_requests")
    public List<ProjectRequest> getProjectsRequests(@PathVariable int projectId) {
        return projectService.getProjectsRequests(projectId);
    }
}
