package com.API_User.API_User.service.implement;

import com.API_User.API_User.dto.LoginDto;
import com.API_User.API_User.entity.User;
import com.API_User.API_User.dto.UserDto;
import com.API_User.API_User.repository.UserRepository;
import com.API_User.API_User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public String addUser(User user) {
        UserDto userDto = new UserDto(
                user.getUserId(),
                user.getRole(),
                user.getUserFirstName(),
                user.getUserLastName(),
                user.getEmail(),
                this.passwordEncoder.encode(user.getPassword()),
                user.getInstitute(),
                user.getProfession(),
                user.getSkills(),
                user.getPhoto(),
                user.getCv(),
                user.getLinkedin(),
                user.getGithub()
        );
        var user1 = userRepository.findByEmail(user.getEmail());
        if (user1.isEmpty()) {
            userRepository.save(userDto);
            return userDto.getUserFirstName();
        } else {
            return "userDto exists";
        }
    }

    @Override
    public Optional<UserDto> getUser(LoginDto loginDto) {
        return userRepository.findByEmail(loginDto.getEmail())
                .filter(user -> {
                    var password = loginDto.getPassword();
                    var encodedPassword = user.getPassword();
                    return passwordEncoder.matches(password, encodedPassword);
                });
    }

    @Override
    public List<UserDto> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDto getUserById(int id) {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("UserDto with id " + id + " not found"));
    }


    @Override
    public void updateUser(int id, User user) {
        UserDto userDtoFromDb = getUserById(id);
        System.out.println(userDtoFromDb.toString());

        userDtoFromDb.setUserFirstName(user.getUserFirstName());
        userDtoFromDb.setUserLastName(user.getUserLastName());
        userDtoFromDb.setEmail(user.getEmail());
        userDtoFromDb.setPassword(this.passwordEncoder.encode(user.getPassword()));
        userDtoFromDb.setInstitute(user.getInstitute());
        userDtoFromDb.setProfession(user.getProfession());
        userDtoFromDb.setSkills(user.getSkills());
        userDtoFromDb.setPhoto(user.getPhoto());
        userDtoFromDb.setCv(user.getCv());
        userDtoFromDb.setLinkedin(user.getLinkedin());
        userDtoFromDb.setGithub(user.getGithub());

        userRepository.save(userDtoFromDb);

    }

    @Override
    public void deleteUser(int userId) {
        userRepository.deleteById(userId);

    }

    @Override
    public Optional<UserDto> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
