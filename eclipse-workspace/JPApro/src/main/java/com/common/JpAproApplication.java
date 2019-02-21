package com.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class JpAproApplication {

//	private static final String PROPERTIES = "spring.config.location=classpath:/google.yml";
	
	public static void main(String[] args) {
		SpringApplication.run(JpAproApplication.class, args);
		
	}

}

