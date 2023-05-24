package com.API_User.API_User.repository;

import com.API_User.API_User.dto.ProjectDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@EnableJpaRepositories
@RepositoryRestResource
public interface ProjectRepository extends JpaRepository<ProjectDto, Integer> {
}
