package com.jonathankim.monster_factory;

import com.jonathankim.monster_factory.controller.MonsterController;
import com.jonathankim.monster_factory.service.MonsterService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
public class MonsterFactoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonsterFactoryApplication.class, args);
	}

}
