package com.karan.backend_user_authentication_system_jwtspringsecuritymysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.karan")
@EnableJpaRepositories(basePackages = "com.karan")
@EntityScan(basePackages = "com.karan")
public class BackendUserAuthenticationSystemJwtspringsecuritymysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendUserAuthenticationSystemJwtspringsecuritymysqlApplication.class, args);
	}

}
