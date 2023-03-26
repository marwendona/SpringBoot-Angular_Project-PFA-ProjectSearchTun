package com.API_User.API_User.service.implement;

import com.API_User.API_User.dto.LoginDto;
import com.API_User.API_User.dto.UserDto;
import com.API_User.API_User.entity.User;
import com.API_User.API_User.repository.UserRepository;
import com.API_User.API_User.service.UserService;
import com.API_User.API_User.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImplement implements UserService {
    @Autowired
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
    @Override
    public String addUser(UserDto userDto) {
        User user = new User(
                userDto.getUserDtoId(),
                userDto.getUserDtoName(),
                userDto.getUserDtoEmail(),
                this.passwordEncoder.encode(userDto.getUserDtoPassword())
        );
        userRepository.save(user);
        return user.getUserName();
    }
    @Override
    public LoginResponse loginUser(LoginDto loginDTO) {
        String msg = "";
        User user1 = userRepository.findUserByUserEmail(loginDTO.getLoginDtoEmail());
        if (user1 != null) {
            String password = loginDTO.getLoginDtoPassword();
            String encodedPassword = user1.getUserPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user = userRepository.findUserByUserEmailAndUserPassword(loginDTO.getLoginDtoEmail(), encodedPassword);
                if (user.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("password Not Match", false);
            }
        } else {
            return new LoginResponse("Email not exits", false);
        }
    }
}
