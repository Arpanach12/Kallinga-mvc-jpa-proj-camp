package com.mindtree.librarymanagementsystem.security.jwt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.mindtree.librarymanagementsystem.modules.common.apiconfig.ApiResponse;

/**
 * @author M1049006
 *
 */
/*This is used to handle all the Authentication Exceptions*/
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {

		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setBody("Failed !!!");
		apiResponse.setError(true);
		apiResponse.setMessage(authException.getMessage());
		apiResponse.setStatus(HttpStatus.UNAUTHORIZED);
		String jsonLoginResponse = new Gson().toJson(apiResponse);
		response.setContentType("application/json");
		response.setStatus(401);
		response.getWriter().print(jsonLoginResponse);
	}

}
