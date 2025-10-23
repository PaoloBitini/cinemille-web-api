package com.paolo.cinemille;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*
 * @EntityScan e @EnableJpaRepository non sarebbero necessari
 * tuttavia aggiungo queste notazioni per specifiare il package corretto 
 */

@SpringBootApplication
@EntityScan(basePackages = "com.paolo.cinemille.entities")
@EnableJpaRepositories(basePackages = "com.paolo.cinemille.repositories")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
