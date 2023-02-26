package com.example.myfirstspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication()
public class MyfirstspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyfirstspringApplication.class, args);
	}

}
