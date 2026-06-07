package com.apisentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ApiSentinelBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiSentinelBackendApplication.class, args);
	}

}
