package com.API_User.API_User.controller;

import com.API_User.API_User.dto.UserDto;
import com.API_User.API_User.dto.LoginDto;
import com.API_User.API_User.service.UserService;
import com.API_User.API_User.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
@RequestMapping ("api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping(path="/save")
    public String saveUser(@RequestBody UserDto userDto){
        String id = userService.addUser(userDto);
        return id;

    }
    @PostMapping(path="/login")
    public ResponseEntity<?>loginUser(@RequestBody LoginDto loginDTO){
        LoginResponse loginResponse=userService.loginUser(loginDTO);
       return ResponseEntity.ok(loginResponse);
    }
}
