package com.API_User.API_User.service.implement;

import com.API_User.API_User.dto.LoginDto;
import com.API_User.API_User.dto.UserDto;
import com.API_User.API_User.entity.User;
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
    public String addUser(UserDto userDto) {
        User user = new User(
                userDto.getUserId(),
                userDto.getRole(),
                userDto.getUserFirstName(),
                userDto.getUserLastName(),
                userDto.getEmail(),
                this.passwordEncoder.encode(userDto.getPassword()),
                userDto.getInstitute(),
                userDto.getProfession(),
                userDto.getSkills(),
                userDto.getPhoto(),
                userDto.getCv(),
                userDto.getLinkedin(),
                userDto.getGithub()
        );
        var user1 = userRepository.findByEmail(userDto.getEmail());
        if (user1.isEmpty()) {
            userRepository.save(user);
            return user.getUserFirstName();
        } else {
            return "user exists";
        }
    }

    @Override
    public Optional<User> getUser(LoginDto loginDto) {
        return userRepository.findByEmail(loginDto.getEmail())
                .filter(user -> {
                    var password = loginDto.getPassword();
                    var encodedPassword = user.getPassword();
                    return passwordEncoder.matches(password, encodedPassword);
                });
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User with id " + id + " not found"));
    }


    @Override
    public void updateUser(int id, UserDto user) {
        User userFromDb = getUserById(id);
        System.out.println(userFromDb.toString());

        userFromDb.setUserFirstName(user.getUserFirstName());
        userFromDb.setUserLastName(user.getUserLastName());
        userFromDb.setEmail(user.getEmail());
        userFromDb.setPassword(this.passwordEncoder.encode(user.getPassword()));
        userFromDb.setInstitute(user.getInstitute());
        userFromDb.setProfession(user.getProfession());
        userFromDb.setSkills(user.getSkills());
        userFromDb.setPhoto(user.getPhoto());
        userFromDb.setCv(user.getCv());
        userFromDb.setLinkedin(user.getLinkedin());
        userFromDb.setGithub(user.getGithub());

        userRepository.save(userFromDb);

    }

    @Override
    public void deleteUser(int userId) {
        userRepository.deleteById(userId);

    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
