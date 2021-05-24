package com.mindtree.librarymanagementsystem;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibraryManagementSystem {

	
	@GetMapping("/")
	public String getWelcomeMessage() {
		return "Welcome to Library Management System dev-1.1";
	}
	
}
