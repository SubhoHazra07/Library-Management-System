package com.webapp.librarymanagementapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.webapp.librarymanagementapp.dao.UserRepository;


@SpringBootApplication
//@ComponentScan(basePackages = "com.webapp.librarymanagementapp")  
public class LibrarymanagementappApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(LibrarymanagementappApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);
		
	}

}
