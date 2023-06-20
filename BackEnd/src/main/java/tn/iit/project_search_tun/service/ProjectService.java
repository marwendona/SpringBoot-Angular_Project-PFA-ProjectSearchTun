package tn.iit.project_search_tun.service;

import tn.iit.project_search_tun.dto.ProjectDto;
import tn.iit.project_search_tun.entity.project.Project;
import tn.iit.project_search_tun.entity.project_request.ProjectRequest;

import java.util.List;

public interface ProjectService {
    List<Project> getAllProjects();

    ProjectDto findProjectById(int projectId);

    Project getProject(int projectId);

    void updateProject(int id, Project project);

    void deleteProject(int projectId);

    int createProjectRequest(int projectId, ProjectRequest projectRequest);

    List<ProjectRequest> getProjectsRequests(int projectId);
}
