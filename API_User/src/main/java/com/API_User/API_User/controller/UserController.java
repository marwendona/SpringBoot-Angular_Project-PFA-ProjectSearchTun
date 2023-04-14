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
    public String test(){

        return "test";
    }

    @PostMapping(path="/login")
    @PreAuthorize("permitAll()")
    public String loginUser(@RequestBody LoginDto loginDTO){
        var userOptional = userService.getUser(loginDTO);
        if (userOptional.isEmpty()){
            throw new IllegalArgumentException("User not found");
        }
        var user = userOptional.get();
        var now = new Date();
        return Jwts.builder()
                .setSubject(user.getEmail())
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + 60 * 10 * 1000))
                .claim("roles", Role.ADMIN)
                .signWith(SignatureAlgorithm.HS512, "secret-key")
                .compact();
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> Users = userService.getUsers();
        return new ResponseEntity<>(Users, HttpStatus.OK);
    }

    @GetMapping({"/{userId}"})
    public ResponseEntity<User> getUser(@PathVariable int userId) {
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }


    @PutMapping({"/{userId}"})
    public ResponseEntity<User> updateTodo(@PathVariable("userId") int userId, @RequestBody User user) {
        userService.updateUser(userId, user);
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }

    @DeleteMapping({"/{userId}"})
    public ResponseEntity<User> deleteTodo(@PathVariable("userId") int userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
