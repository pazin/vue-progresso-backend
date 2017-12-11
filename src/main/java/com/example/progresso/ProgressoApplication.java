package com.example.progresso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ProgressoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgressoApplication.class, args);
	}
}
