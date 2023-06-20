package tn.iit.project_search_tun.controller;

import tn.iit.project_search_tun.dto.UserDto;
import tn.iit.project_search_tun.entity.project.Project;
import tn.iit.project_search_tun.entity.project_request.ProjectRequest;
import tn.iit.project_search_tun.entity.user.User;
import tn.iit.project_search_tun.security.UserDetailsImpl;
import tn.iit.project_search_tun.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/user")
@Validated
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/test")
    @PreAuthorize("hasRole('ADMIN')")
    public String test() {
        return "test";
    }

    @PostMapping(path = "/save")
    public String saveUser(@RequestBody @Valid User user) {
        String id = userService.addUser(user);
        return id;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> userDtos = userService.getUsers();
        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }

    @GetMapping("/info")
    public UserDto getUser() {
        var userId = getUserId();
        return userService.getUserById(userId);
    }

    @PutMapping({"/update"})
    public ResponseEntity<UserDto> updateUser(@RequestBody User user) {
        userService.updateUser(getUserId(), user);
        return new ResponseEntity<>(userService.getUserById(getUserId()), HttpStatus.OK);
    }

    @DeleteMapping({"/delete"})
    public ResponseEntity<UserDto> deleteUser() {
        userService.deleteUser(getUserId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/projects")
    public String addProject(@RequestBody @Valid Project project) {
        var userId = getUserId();
        String id = userService.addProject(project, userId);
        return id;
    }

    @GetMapping("/projects")
    public List<Project> getProjects() {
        return userService.getProjects(getUserId());
    }

//    la version que j ai changer pour ne pas passer l id en url et je fait ça pour tous
//    @GetMapping("{userId}/projects")
//    public List<Project> getProjects(@PathVariable int userId) {
//        return userService.getProjects(userId);
//    }

    @GetMapping("/projects_requests")
    public List<ProjectRequest> getProjectsRequests() {
        return userService.getProjectsRequests(getUserId());
    }

    private static int getUserId() {
        return ((UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
    }
}