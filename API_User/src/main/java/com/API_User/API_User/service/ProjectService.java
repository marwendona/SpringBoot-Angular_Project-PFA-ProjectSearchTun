package com.API_User.API_User.service;

import com.API_User.API_User.dto.ProjectDto;
import com.API_User.API_User.entity.project.Project;

import java.util.List;

public interface ProjectService {
    List<Project> getAllProjects();

    ProjectDto findProjectById(int projectId);

    Project getProject(int projectId);

    void updateProject(int id, Project project);

    void deleteProject(int projectId);


}
