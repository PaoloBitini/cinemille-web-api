package com.paolo.cinemille;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.paolo.cinemille.entities")
@ComponentScan(basePackages = {
		"com.paolo.cinemille.config",
		"com.paolo.cinemille.controllers",
		"com.paolo.cinemille.services",
		"com.paolo.cinemille.repositories"
})
@EnableJpaRepositories(basePackages = "com.paolo.cinemille.repositories")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
