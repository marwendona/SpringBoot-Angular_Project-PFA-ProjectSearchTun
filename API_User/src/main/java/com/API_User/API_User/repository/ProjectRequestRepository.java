package com.API_User.API_User.repository;

import com.API_User.API_User.dto.ProjectRequestDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@EnableJpaRepositories
@RepositoryRestResource
public interface ProjectRequestRepository extends JpaRepository<ProjectRequestDto, Integer> {
//    List<ProjectRequestDto> findAllByProjectId(int projectId);
}
