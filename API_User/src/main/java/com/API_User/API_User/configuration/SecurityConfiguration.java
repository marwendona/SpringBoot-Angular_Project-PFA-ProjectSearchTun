package com.API_User.API_User.configuration;

import jakarta.servlet.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import java.io.IOException;
import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeHttpRequests(authorize -> {
                    authorize.requestMatchers("/api/v1/user/login").permitAll();
                    authorize.requestMatchers("/api/**").authenticated();
                }).addFilterAt(new Filter() {
            @Override
            public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
                GrantedAuthority authority = new SimpleGrantedAuthority("myAuthority");
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken("user", "token", Arrays.asList(authority));
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }, BasicAuthenticationFilter.class);
                //.requestMatchers("/api/v1/user/login/").permitAll()
                //.requestMatchers("/api/**").authenticated()

        return http.build();
    }
     */
}
