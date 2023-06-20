package tn.iit.project_search_tun.service;

import tn.iit.project_search_tun.dto.LoginDto;
import tn.iit.project_search_tun.dto.UserDto;
import tn.iit.project_search_tun.entity.project.Project;
import tn.iit.project_search_tun.entity.project_request.ProjectRequest;
import tn.iit.project_search_tun.entity.user.User;

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

    List<ProjectRequest> getProjectsRequests(int userId);
}
