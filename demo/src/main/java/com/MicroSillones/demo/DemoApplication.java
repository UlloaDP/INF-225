package com.MicroSillones.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.MicroSillones.request"})
@EnableJpaRepositories("com.MicroSillones.repository")
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.MicroSillones.model"})
@ComponentScan(basePackages = {"com.MicroSillones.service"})// scan JPA entities
@ComponentScan(basePackages = {"com.MicroSillones.controller"})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
