package com.API_User.API_User.service.implement;

import com.API_User.API_User.adapter.ProjectAdapter;
import com.API_User.API_User.dto.ProjectDto;
import com.API_User.API_User.entity.project.Project;
import com.API_User.API_User.exception.ResourceNotFoundException;
import com.API_User.API_User.repository.ProjectRepository;
import com.API_User.API_User.repository.UserRepository;
import com.API_User.API_User.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

import static com.API_User.API_User.adapter.ProjectAdapter.toProject;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    //private final ProjectRequestRepository projectRequestRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository, UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
        //this.projectRequestRepository = projectRequestRepository;
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll()
                .stream()
                .map(ProjectAdapter::toProject)
                .collect(Collectors.toList());
    }

    @Override
    public ProjectDto findProjectById(int projectId) {
        return projectRepository.findById(projectId).orElseThrow(() -> new ResourceNotFoundException("Project not found"));
    }

    @Override
    public Project getProject(@PathVariable int projectId) {
        var projectDto = findProjectById(projectId);
        return toProject(projectDto);
    }

    @Override
    public void updateProject(int id, Project project) {
        ProjectDto projectDtoFromDb = findProjectById(id);
        System.out.println(projectDtoFromDb.toString());

        projectDtoFromDb.setTitle(project.getTitle());
        projectDtoFromDb.setType(project.getType());
        projectDtoFromDb.setDescription(project.getDescription());
        projectDtoFromDb.setRequiredSkills(project.getRequiredSkills());
        projectDtoFromDb.setCreatedDate(project.getCreatedDate());
        projectDtoFromDb.setNumberOfMembers(project.getNumberOfMembers());
        projectDtoFromDb.setProjectStatus(project.getProjectStatus());

        projectRepository.save(projectDtoFromDb);
    }


    @Override
    public void deleteProject(int projectId) {
        projectRepository.deleteById(projectId);
    }



//    private static void fillBidDto(ProjectRequestDto projectRequestDto, ProjectRequest projectRequest) {
//        projectRequestDto.setProjectRequestDate(projectRequest.getProjectRequestDate());
//    }
}
