package com.mindtree.igmanagement.exceptionhandler;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mindtree.igmanagement.controller.IgManagementController;
import com.mindtree.igmanagement.exceptions.controllerexception.IgManagementControllerException;

@RestControllerAdvice(assignableTypes = {IgManagementController.class})
public class IgManagementExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<Map<String,Object>> exceptionHandler(IgManagementControllerException c, Throwable cause){
		
		Map<String,Object> error = new LinkedHashMap<String,Object>();
		error.put("Header", "An exception occured");
		error.put("Body", c.getMessage());
		error.put("Http Status", HttpStatus.BAD_REQUEST);
		error.put("error",true);
		
		return new ResponseEntity<Map<String,Object>>(error, HttpStatus.BAD_REQUEST);
	}
}
