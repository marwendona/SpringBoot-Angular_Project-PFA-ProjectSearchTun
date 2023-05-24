package com.API_User.API_User.service.implement;

import com.API_User.API_User.adapter.ProjectAdapter;
import com.API_User.API_User.entity.project.Project;
import com.API_User.API_User.repository.ProjectRepository;
import com.API_User.API_User.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

//    public List<ProjectDto> getAllProjects() {
//        return projectRepository.findAll();
//    }

//    public List<ProjectDto> getAllProjects() {
//        List<Project> projects = projectRepository.findAll();
//        List<ProjectDto> projectDtos = new ArrayList<>();
//        for (Project project : projects) {
//            projectDtos.add(new ProjectDto(project));
//        }
//        return projectDtos;
//    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll()
                .stream()
                .map(ProjectAdapter::toProject)
                .collect(Collectors.toList());
    }
}
