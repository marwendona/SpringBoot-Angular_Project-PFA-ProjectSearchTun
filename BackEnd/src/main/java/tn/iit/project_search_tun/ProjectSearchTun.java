package tn.iit.project_search_tun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ProjectSearchTun {

	public static void main(String[] args) {

		SpringApplication.run(ProjectSearchTun.class, args);
	}

}
