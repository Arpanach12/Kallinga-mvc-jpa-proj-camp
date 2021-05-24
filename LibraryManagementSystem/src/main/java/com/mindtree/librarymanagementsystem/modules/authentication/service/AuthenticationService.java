package com.mindtree.librarymanagementsystem.modules.authentication.service;

import com.mindtree.librarymanagementsystem.modules.authentication.dto.SignUpRequest;
import com.mindtree.librarymanagementsystem.modules.user.entity.User;

public interface AuthenticationService {

	public User registerUser(SignUpRequest signUpRequest);

}
