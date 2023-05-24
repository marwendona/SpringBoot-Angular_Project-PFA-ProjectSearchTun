package com.API_User.API_User.controller;

import com.API_User.API_User.dto.LoginDto;
import com.API_User.API_User.security.JwtService;
import com.API_User.API_User.security.UserDetailsImpl;
import com.API_User.API_User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/auth")
public class AuthenticationController {

    private UserService userService;
    private JwtService jwtService;

    @Autowired
    public AuthenticationController(UserService userService, JwtService jwtService){
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @PostMapping(path = "/authenticate")
    public String authenticate(Authentication authentication) {
        authentication.getCredentials();
        var user = userService.getUser(new LoginDto(authentication.getName(), (String) authentication.getCredentials())).orElseThrow();
        return jwtService.generateToken(new UserDetailsImpl(user));

    }

    @PostMapping(path = "/test")
    public String test() {
//        var userOptional = userService.getUser(loginDTO);
//        if (userOptional.isEmpty()){
//            throw new IllegalArgumentException("UserDto not found");
//        }
//        var user = userOptional.get();
//        var now = new Date();
//        return Jwts.builder()
//                .setSubject(user.getEmail())
//                .setIssuedAt(now)
//                .setExpiration(new Date(now.getTime() + 60 * 10 * 1000))
//                .claim("roles", Role.ADMIN)
//                .signWith(SignatureAlgorithm.HS512, "secret-key")
//                .compact();
//    }
        return "";
    }
}
