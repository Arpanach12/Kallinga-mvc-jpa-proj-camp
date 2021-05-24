package com.mindtree.classmanagementmvc.exceptionhandler;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mindtree.classmanagementmvc.controller.ClassManagementController;
import com.mindtree.classmanagementmvc.exception.controllerexception.ClassManagementControllerException;

@ControllerAdvice(assignableTypes = ClassManagementController.class)
public class ClassManagamentExceptionHandler {

	@ExceptionHandler
	public String exceptionHandler(ClassManagementControllerException c,Model model) {
		
		Map<String,Object> error = new LinkedHashMap<String, Object>();
		error.put("message" , c.getMessage());
		error.put("TimeStamp", new Date());
		error.put("HttpStatus", HttpStatus.BAD_REQUEST.value());
		model.addAttribute("error",error);
		return "registerstudent";
	}
}
