package br.com.projectpd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectPdApplication {

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/project-pd");
		SpringApplication.run(ProjectPdApplication.class, args);
	}

}
