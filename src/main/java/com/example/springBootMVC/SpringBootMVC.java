package com.example.springBootMVC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.example.springBootMVC.repositoryMongoDB")
public class SpringBootMVC {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMVC.class, args);
	}

}
