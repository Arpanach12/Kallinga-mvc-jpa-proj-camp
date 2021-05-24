package com.mindtree.librarymanagementsystem.modules.common.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mindtree.librarymanagementsystem.modules.common.apiconfig.ApiResponse;
import com.mindtree.librarymanagementsystem.modules.common.exceptions.RecordNotFoundException;
import com.mindtree.librarymanagementsystem.modules.feedback.controller.FeedbackController;
import com.mindtree.librarymanagementsystem.modules.transaction.controller.IssueRecordController;

@RestControllerAdvice(assignableTypes = {FeedbackController.class,IssueRecordController.class})
public class GlobalHandler {

	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<ApiResponse> recordNotFoundHandler(Exception e,Throwable t){
		
		 ApiResponse apiResponse=new ApiResponse();
	     apiResponse.setBody(null);
	     apiResponse.setMessage(e.getMessage());
	     apiResponse.setError(true);
	     apiResponse.setStatus(HttpStatus.BAD_REQUEST);
	     return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
	}
	
}
