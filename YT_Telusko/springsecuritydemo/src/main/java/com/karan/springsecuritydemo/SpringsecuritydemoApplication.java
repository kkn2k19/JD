package com.karan.springsecuritydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.karan")
@EntityScan("com.karan")
@EnableJpaRepositories("com.karan")
public class SpringsecuritydemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecuritydemoApplication.class, args);
	}

}
