package com.mindtree.librarymanagementsystem.modules.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.librarymanagementsystem.modules.authentication.dto.JWTLoginSuccessResponse;
import com.mindtree.librarymanagementsystem.modules.authentication.dto.LoginRequest;
import com.mindtree.librarymanagementsystem.modules.authentication.dto.SignUpRequest;
import com.mindtree.librarymanagementsystem.modules.authentication.service.AuthenticationService;
import com.mindtree.librarymanagementsystem.modules.common.apiconfig.ApiResponse;
import com.mindtree.librarymanagementsystem.modules.user.repository.UserRepository;
import com.mindtree.librarymanagementsystem.security.constant.SecurityConstant;
import com.mindtree.librarymanagementsystem.security.entity.LMSUserDetail;
import com.mindtree.librarymanagementsystem.security.jwt.JwtTokenProvider;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManger;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuthenticationService authanticationService;

	@Autowired
	private JwtTokenProvider jwtProvider;

	
	
	@PostMapping("/login")
	public ResponseEntity<ApiResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManger.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = SecurityConstant.TOKEN_PREFIX + jwtProvider.generateToken(authentication);
		LMSUserDetail userDetails = (LMSUserDetail) authentication.getPrincipal();
		System.out.println(jwt);
		ApiResponse apiResponse=new ApiResponse();
		apiResponse.setBody(new JWTLoginSuccessResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities(),userDetails.getUserId()));
		apiResponse.setSuccess(true);
		apiResponse.setError(false);
		apiResponse.setMessage("Logged In Successful");
		apiResponse.setStatus(HttpStatus.OK);
		
		return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
		
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody SignUpRequest signUpRequest) {
		ApiResponse response = new ApiResponse();
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			response.setBody(null);
			response.setError(true);
			response.setMessage("Username is already taken.");
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setSuccess(false);
		} else if (userRepository.existsByEmailId(signUpRequest.getEmailId())) {
			response.setBody(null);
			response.setError(true);
			response.setMessage("Email is already taken.");
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setSuccess(false);
		} else {
			authanticationService.registerUser(signUpRequest);
			response.setBody("User Registered");
			response.setError(false);
			response.setMessage("User successfully registered.");
			response.setStatus(HttpStatus.CREATED);
			response.setSuccess(true);
		}

		return new ResponseEntity<>(response, HttpStatus.OK);

	}
}
