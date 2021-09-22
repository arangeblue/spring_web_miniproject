package com.webproject.web_miniproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@SpringBootApplication
public class WebMiniprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebMiniprojectApplication.class, args);
	}

}
