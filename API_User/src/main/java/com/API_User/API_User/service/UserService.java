package com.API_User.API_User.service;

import com.API_User.API_User.dto.LoginDto;
import com.API_User.API_User.entity.User;
import com.API_User.API_User.dto.UserDto;

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
}
