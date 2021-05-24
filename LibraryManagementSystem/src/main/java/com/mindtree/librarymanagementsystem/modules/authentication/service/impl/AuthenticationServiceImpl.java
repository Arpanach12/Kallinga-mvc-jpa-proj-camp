package com.mindtree.librarymanagementsystem.modules.authentication.service.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mindtree.librarymanagementsystem.modules.authentication.dto.SignUpRequest;
import com.mindtree.librarymanagementsystem.modules.authentication.service.AuthenticationService;
import com.mindtree.librarymanagementsystem.modules.common.enums.RoleName;
import com.mindtree.librarymanagementsystem.modules.common.enums.UserStatus;
import com.mindtree.librarymanagementsystem.modules.user.entity.Role;
import com.mindtree.librarymanagementsystem.modules.user.entity.User;
import com.mindtree.librarymanagementsystem.modules.user.repository.RoleRepository;
import com.mindtree.librarymanagementsystem.modules.user.repository.UserRepository;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public User registerUser(SignUpRequest signUpRequest) {
		User user = new User();
		user.setUserName(signUpRequest.getUsername());
		user.setFullName(signUpRequest.getFullName());
		user.setAge(signUpRequest.getAge());
		user.setFullName(signUpRequest.getFullName());
		user.setPhoneNumber(signUpRequest.getPhoneNumber());
		user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
		user.setEmailId(signUpRequest.getEmailId());
		user.setUserStatus(UserStatus.ACTIVE);
		user.setDateOfJoining(LocalDate.now());
		Role role = roleRepository.findByRoleName(RoleName.ROLE_USER).orElseThrow(() -> new RuntimeException());
		user.getRole().add(role);
		return userRepository.save(user);
	}

}
