package tn.iit.project_search_tun.repository;

import tn.iit.project_search_tun.dto.ProjectDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@EnableJpaRepositories
@RepositoryRestResource
public interface ProjectRepository extends JpaRepository<ProjectDto, Integer> {
}
