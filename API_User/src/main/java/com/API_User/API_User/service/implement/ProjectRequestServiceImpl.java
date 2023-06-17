package com.API_User.API_User.service.implement;

import com.API_User.API_User.entity.project_request.ProjectRequestStatus;
import com.API_User.API_User.exception.ResourceNotFoundException;
import com.API_User.API_User.repository.ProjectRequestRepository;
import com.API_User.API_User.service.ProjectRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class ProjectRequestServiceImpl implements ProjectRequestService {
    private final ProjectRequestRepository projectRequestRepository;

    @Autowired
    public ProjectRequestServiceImpl(ProjectRequestRepository projectRequestRepository) {
        this.projectRequestRepository = projectRequestRepository;
    }

    @Override
    public ProjectRequestStatus acceptOrRejectProjectRequest(int projectRequestId, ProjectRequestStatus status) {
        var projectRequestDto = projectRequestRepository.findById(projectRequestId)
                .orElseThrow(() -> new ResourceNotFoundException("Project Request not found"));
        projectRequestDto.setStatus(status);

        projectRequestRepository.save(projectRequestDto);

        return projectRequestDto.getStatus();
    }

    //        ProjectRequestDto projectRequestDto1 = projectRequestRepository.findById(projectId).orElseThrow(() -> new RuntimeException());
    //        projectRequestDto1.setStatus(ProjectRequestStatus.ACCEPTED);
    //        projectRequestRepository.save(projectRequestDto1);
}
