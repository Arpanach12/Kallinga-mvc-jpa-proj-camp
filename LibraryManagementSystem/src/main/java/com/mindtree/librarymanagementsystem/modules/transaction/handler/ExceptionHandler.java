package com.mindtree.librarymanagementsystem.modules.transaction.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mindtree.librarymanagementsystem.modules.common.apiconfig.ApiResponse;
import com.mindtree.librarymanagementsystem.modules.transaction.exception.serviceexception.IssueRecordDoesNotExistException;

@RestControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(IssueRecordDoesNotExistException.class)
	public ResponseEntity<ApiResponse> issueRecordDoesNotExistException(Exception e)
	{
		ApiResponse apiResponse=new ApiResponse();
		apiResponse.setError(true);
		apiResponse.setSuccess(false);
		apiResponse.setMessage(e.getMessage());
		apiResponse.setBody(e.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
	}
	
	
}
