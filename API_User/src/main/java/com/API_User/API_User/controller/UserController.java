package com.API_User.API_User.controller;

import com.API_User.API_User.dto.ProjectDto;
import com.API_User.API_User.entity.project.Project;
import com.API_User.API_User.entity.project_request.ProjectRequest;
import com.API_User.API_User.entity.user.User;
import com.API_User.API_User.dto.UserDto;
import com.API_User.API_User.security.UserDetailsImpl;
import com.API_User.API_User.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin
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

    @GetMapping({"/{userId}"})
    public UserDto getUser(@PathVariable int userId) {
        return userService.getUserById(userId);
    }


    @PutMapping({"/{userId}"})
    public ResponseEntity<UserDto> updateUser(@PathVariable("userId") int userId, @RequestBody User user) {
        userService.updateUser(userId, user);
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }

    @DeleteMapping({"/{userId}"})
    public ResponseEntity<UserDto> deleteUser(@PathVariable("userId") int userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/projects")
    public String addProject(@RequestBody @Valid Project project) {
        var userId = getUserId();
        String id = userService.addProject(project, userId);
        return id;
    }

    @GetMapping("{userId}/projects")
    public List<Project> getProjects(@PathVariable int userId) {
        return userService.getProjects(userId);
    }



    private static int getUserId() {
        return ((UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
    }
}