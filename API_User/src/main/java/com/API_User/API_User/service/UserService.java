package com.API_User.API_User.service;

import com.API_User.API_User.dto.LoginDto;
import com.API_User.API_User.dto.UserDto;
import com.API_User.API_User.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    String addUser(UserDto userDto);

    Optional<User> getUser(LoginDto loginDto);

    List<User> getUsers();
    User getUserById(int id);
    void updateUser(int id, UserDto user);
    void deleteUser(int userId);

    Optional<User> findByEmail(String username);
}
