package com.API_User.API_User.repository;

import com.API_User.API_User.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@EnableJpaRepositories
@Repository
public interface UserRepository extends JpaRepository<UserDto,Integer> {
    Optional<UserDto> findByEmail(String email);
}
