package tn.iit.project_search_tun.repository;

import tn.iit.project_search_tun.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@EnableJpaRepositories
@Repository
public interface UserRepository extends JpaRepository<UserDto,Integer> {
    Optional<UserDto> findByEmail(String email);
}
