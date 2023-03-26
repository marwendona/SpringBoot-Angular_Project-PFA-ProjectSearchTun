package com.API_User.API_User;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ApiUserApplication {

	public static void main(String[] args) {

		SpringApplication.run(ApiUserApplication.class, args);
	}

}
