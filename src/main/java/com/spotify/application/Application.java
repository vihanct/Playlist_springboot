package com.spotify.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception{

	}
}
