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

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImplement implements UserService {
    @Autowired
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
    @Override
    public String addUser(UserDto userDto) {
        User user = new User(
                userDto.getUserId(),
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
        User user1 = userRepository.findByEmail(userDto.getEmail());
        if (user1 == null) {
            userRepository.save(user);
            return user.getUserFirstName();
        }else{
            return "user exists";
        }
    }
    @Override
    public LoginResponse loginUser(LoginDto loginDto) {
        String msg = "";
        User user1 = userRepository.findByEmail(loginDto.getEmail());
        if (user1 != null) {
            String password = loginDto.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user = userRepository.findOneByEmailAndPassword(loginDto.getEmail(), encodedPassword);
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

    @Override
    public Optional<User> getUser(LoginDto loginDto) {
        var user = userRepository.findByEmail(loginDto.getEmail());
        if (user != null){
            var password = loginDto.getPassword();
            var encodedPassword = user.getPassword();
            if (passwordEncoder.matches(password, encodedPassword)){
                return Optional.of(user);
            }
        }
        return Optional.empty();
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
    public void updateUser(int id, User user) {
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
        userFromDb.setGitub(user.getGithub());

        userRepository.save(userFromDb);

    }

    @Override
    public void deleteUser(int userId) {
        userRepository.deleteById(userId);

    }
}
