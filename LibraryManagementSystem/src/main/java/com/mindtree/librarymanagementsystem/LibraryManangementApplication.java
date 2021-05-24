package com.mindtree.librarymanagementsystem;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
public class LibraryManangementApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryManangementApplication.class, args);
	}
	/**
	 * for war file.
	 */
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(LibraryManangementApplication.class);
	}

	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}



	/*
	 * @Bean public ModelMapper ModelMapper() { return new ModelMapper(); }
	 */


	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}



}
