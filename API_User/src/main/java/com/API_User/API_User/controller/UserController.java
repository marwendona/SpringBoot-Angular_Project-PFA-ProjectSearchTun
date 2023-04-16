package com.API_User.API_User.controller;

import com.API_User.API_User.dto.UserDto;
import com.API_User.API_User.dto.LoginDto;
import com.API_User.API_User.entity.Role;
import com.API_User.API_User.entity.User;
import com.API_User.API_User.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping ("api/v1/user")
@Validated
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(path="/save")
    public String saveUser(@RequestBody @Valid UserDto userDto){
        String id = userService.addUser(userDto);
        return id;
    }

    @GetMapping(path = "/test")
    @PreAuthorize("hasRole('ADMIN')")
    public String test(){
        return "test";
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> Users = userService.getUsers();
        return new ResponseEntity<>(Users, HttpStatus.OK);
    }

    @GetMapping({"/{userId}"})
    public User getUser(@PathVariable int userId) {
        return userService.getUserById(userId);
    }


    @PutMapping({"/{userId}"})
    public ResponseEntity<User> update(@PathVariable("userId") int userId, @RequestBody UserDto user) {
        userService.updateUser(userId, user);
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }

    @DeleteMapping({"/{userId}"})
    public ResponseEntity<User> delete(@PathVariable("userId") int userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
