package com.group5.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.group5.repo.MoviesRepository;

@SpringBootApplication
@ComponentScan("com.group5")
@EnableMongoRepositories(basePackageClasses = MoviesRepository.class)
public class MovieAdminServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieAdminServiceApplication.class, args);
	}

}
