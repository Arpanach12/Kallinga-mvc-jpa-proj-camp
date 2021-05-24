package com.example.demo.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.ServiceException;

@RestControllerAdvice(assignableTypes = ChannelController.class)
public class ChannelExceptionHandler {


		
		@ExceptionHandler(ServiceException.class)
		public ResponseEntity<Map<String,Object>> ServiceExceptionHandler(Exception e,Throwable cause){
			Map<String,Object> response=new LinkedHashMap<>();
			response.put("header", "channel");
			response.put("Error", true);
			response.put("body",e.getMessage());
			response.put("Httpstatus", HttpStatus.NOT_FOUND);
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
			
		}
		
}
