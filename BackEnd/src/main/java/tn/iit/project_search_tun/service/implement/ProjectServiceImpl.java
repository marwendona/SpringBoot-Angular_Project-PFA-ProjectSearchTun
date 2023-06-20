package tn.iit.project_search_tun.service.implement;

import tn.iit.project_search_tun.adapter.ProjectAdapter;
import tn.iit.project_search_tun.dto.ProjectDto;
import tn.iit.project_search_tun.dto.ProjectRequestDto;
import tn.iit.project_search_tun.entity.project.Project;
import tn.iit.project_search_tun.entity.project_request.ProjectRequest;
import tn.iit.project_search_tun.entity.project_request.ProjectRequestStatus;
import tn.iit.project_search_tun.exception.ResourceNotFoundException;
import tn.iit.project_search_tun.repository.ProjectRepository;
import tn.iit.project_search_tun.repository.ProjectRequestRepository;
import tn.iit.project_search_tun.repository.UserRepository;
import tn.iit.project_search_tun.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final ProjectRequestRepository projectRequestRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository, UserRepository userRepository, ProjectRequestRepository projectRequestRepository) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
        this.projectRequestRepository = projectRequestRepository;
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
        return ProjectAdapter.toProject(projectDto);
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

    @Override
    public int createProjectRequest(int projectId, ProjectRequest projectRequest) {
        var userDto = userRepository.findById(projectRequest.getUserId()).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        var projectDto = findProjectById(projectId);

        var projectRequestDto = new ProjectRequestDto();
        projectRequestDto.setUser(userDto);
        projectRequestDto.setProject(projectDto);

        projectRequestDto.setStatus(ProjectRequestStatus.PENDING);

        fillProjectRequestDto(projectRequestDto, projectRequest);
        projectRequestDto = projectRequestRepository.save(projectRequestDto);

        return projectRequestDto.getProjectRequestId();
    }

    @Override
    public List<ProjectRequest> getProjectsRequests(int projectId) {
        return projectRepository.findById(projectId)
                .map(ProjectDto::getProjectRequests)
                .map(projectRequestDtos -> projectRequestDtos
                        .stream()
                        .map(projectRequestDto -> {
                            ProjectRequest projectRequest = new ProjectRequest();
                            projectRequest.setProjectRequestId(projectRequestDto.getProjectRequestId());
                            projectRequest.setUserId(projectRequestDto.getUser().getUserId());
                            projectRequest.setProject(ProjectAdapter.toProject(projectRequestDto.getProject()));
                            projectRequest.setProjectRequestDate(projectRequestDto.getProjectRequestDate());
                            projectRequest.setStatus(projectRequestDto.getStatus());
                            return projectRequest;
                        }).toList())
                .orElseGet(Collections::emptyList);
    }

    private static void fillProjectRequestDto(ProjectRequestDto projectRequestDto, ProjectRequest projectRequest) {
        projectRequestDto.setProjectRequestDate(projectRequest.getProjectRequestDate());
    }
}
