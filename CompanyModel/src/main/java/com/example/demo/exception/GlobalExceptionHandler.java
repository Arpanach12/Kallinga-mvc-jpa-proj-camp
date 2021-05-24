package com.example.demo.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
	@Value("${spring.application.name}")
	private String applicationName;

	@ExceptionHandler
	public ModelAndView deafultErrorHandler(HttpServletRequest req,Exception e) {
		ModelAndView modelandview=new ModelAndView();
		modelandview.addObject("ApplicationName",applicationName);
		modelandview.addObject("Status",HttpStatus.NOT_FOUND.value());
		modelandview.addObject("ErrorMessage",e.getMessage());
		modelandview.addObject("url",req.getRequestURI());
		modelandview.setViewName("error");
		
		return modelandview;
	}

	@ExceptionHandler
	public ModelAndView deafultErrorHandler(HttpServletRequest req,BrandCompanyException e) {
		ModelAndView modelandview=new ModelAndView();
		modelandview.addObject("ApplicationName",applicationName);
		modelandview.addObject("Status",HttpStatus.NOT_FOUND.value());
		modelandview.addObject("ErrorMessage",e.getMessage());
		modelandview.addObject("url",req.getRequestURI());
		modelandview.setViewName("error");
		
		return modelandview;
	}
	

}
