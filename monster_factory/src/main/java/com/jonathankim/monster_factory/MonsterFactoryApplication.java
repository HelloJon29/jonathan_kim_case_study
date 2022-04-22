package com.jonathankim.monster_factory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class MonsterFactoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonsterFactoryApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> System.out.println("Monster Factory Application Started!");
	}

}
