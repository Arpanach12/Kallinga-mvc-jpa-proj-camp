package com.mindtree.adminusermvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mindtree.adminusermvc.entity.Person;
import com.mindtree.adminusermvc.exception.AdminUserServiceException;
import com.mindtree.adminusermvc.service.AdminUserService;

@Controller
public class AdminUserController {

	@Autowired
	private AdminUserService service;

	@GetMapping("/")
	public String loginPage() {
		
		return "login";
	}
	
	@GetMapping("/validateuser")
	public String displayPage(@RequestParam String personName,@RequestParam String personPassword, Model model) throws AdminUserServiceException {
		
		String role = service.findRole(personName,personPassword);
		model.addAttribute("role", role);
		return "display";
			
	}
	
	@GetMapping("/registeruser")
	public String registerUser() {
		
		return "register";
	}
	
	@PostMapping("/insertuser")
	public String insertUser(Person person) {
		
		service.insertUser(person);
		return "login";
	}
	
}
