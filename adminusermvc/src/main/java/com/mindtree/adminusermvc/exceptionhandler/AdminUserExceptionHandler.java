package com.mindtree.adminusermvc.exceptionhandler;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mindtree.adminusermvc.controller.AdminUserController;
import com.mindtree.adminusermvc.exception.AdminUserServiceException;

@ControllerAdvice(assignableTypes = { AdminUserController.class })
public class AdminUserExceptionHandler {

	@ExceptionHandler
	public String exceptionHandler(AdminUserServiceException e , Model model ) {

		Map<String, Object> error = new LinkedHashMap<String, Object>();

		error.put("message", "Error Incurred");
		error.put("body", e.getMessage());
		error.put("timestamp", new Date());
		error.put("httpStatus", HttpStatus.NOT_FOUND.value());
		model.addAttribute("error",error);
		return "errorpage";
	}

}
