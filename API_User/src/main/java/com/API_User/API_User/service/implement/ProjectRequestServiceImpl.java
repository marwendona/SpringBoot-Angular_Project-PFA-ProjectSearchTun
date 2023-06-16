package com.API_User.API_User.service.implement;

import com.API_User.API_User.repository.ProjectRequestRepository;
import com.API_User.API_User.service.ProjectRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectRequestServiceImpl implements ProjectRequestService {
    private final ProjectRequestRepository projectRequestRepository;

    @Autowired
    public ProjectRequestServiceImpl(ProjectRequestRepository projectRequestRepository) {
        this.projectRequestRepository = projectRequestRepository;
    }
}
