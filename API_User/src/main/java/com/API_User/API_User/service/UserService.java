package com.API_User.API_User.service;

import com.API_User.API_User.dto.LoginDto;
import com.API_User.API_User.dto.UserDto;
import com.API_User.API_User.entity.User;
import com.API_User.API_User.response.LoginResponse;

import java.util.Optional;

public interface UserService {
    String addUser(UserDto userDto);
    LoginResponse loginUser(LoginDto loginDTO);

    Optional<User> getUser(LoginDto loginDto);
}
