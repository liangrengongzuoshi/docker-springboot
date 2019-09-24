package com.liangzai.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StartUp {

	public static void main(String[] args) {
		System.out.println("Spring boot start.");
		SpringApplication.run(StartUp.class, args);
	}

}
