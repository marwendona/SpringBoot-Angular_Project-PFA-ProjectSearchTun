package com.API_User.API_User.service;

import com.API_User.API_User.dto.LoginDto;
import com.API_User.API_User.dto.ProjectDto;
import com.API_User.API_User.dto.UserDto;
import com.API_User.API_User.entity.project.Project;
import com.API_User.API_User.entity.project_request.ProjectRequest;
import com.API_User.API_User.entity.user.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface UserService {
    String addUser(User user);

    Optional<UserDto> getUser(LoginDto loginDto);

    List<UserDto> getUsers();
    UserDto getUserById(int id);
    void updateUser(int id, User user);
    void deleteUser(int userId);

    Optional<UserDto> findByEmail(String username);

    String addProject(Project project, int userId);

    List<Project> getProjects(int userId);


}
