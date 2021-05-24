package com.mindtree.librarymanagementsystem.modules.transaction.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mindtree.librarymanagementsystem.modules.common.apiconfig.ApiResponse;
import com.mindtree.librarymanagementsystem.modules.transaction.controller.IssueRecordController;
import com.mindtree.librarymanagementsystem.modules.transaction.exception.serviceexception.BookLimitExceededException;
import com.mindtree.librarymanagementsystem.modules.transaction.exception.serviceexception.NoBookIssuedException;
import com.mindtree.librarymanagementsystem.modules.transaction.exception.serviceexception.NoRequestPresentException;
import com.mindtree.librarymanagementsystem.modules.transaction.exception.serviceexception.NoSuchTokenPresentException;
import com.mindtree.librarymanagementsystem.modules.transaction.exception.serviceexception.ReIssueCountException;
import com.mindtree.librarymanagementsystem.modules.transaction.exception.serviceexception.RequestLimitExceededException;


@RestControllerAdvice(assignableTypes = { IssueRecordController.class })
public class TransactionExceptionHandler {

	
	@ExceptionHandler(value =NoBookIssuedException.class)
	public ResponseEntity<Object> noBookexception(Exception exception, Throwable t) {
	     ApiResponse apiResponse=new ApiResponse();
	     apiResponse.setBody(exception.getMessage());
	     apiResponse.setMessage("Book not issued");
	     apiResponse.setError(true);
	     apiResponse.setStatus(HttpStatus.BAD_REQUEST);
	     return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
	   }
	
	@ExceptionHandler(RequestLimitExceededException.class)
	public ResponseEntity<ApiResponse> requestLimitExceedsException(Exception e,Throwable t){
	
		 ApiResponse apiResponse=new ApiResponse();
	     apiResponse.setBody(null);
	     apiResponse.setMessage(e.getMessage());
	     apiResponse.setError(true);
	     apiResponse.setStatus(HttpStatus.BAD_REQUEST);
	     return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
	}
//	@ExceptionHandler(RecordNotFoundException.class)
//	public ResponseEntity<ApiResponse> recordNotFoundHandler(Exception e,Throwable t){
//		
//		 ApiResponse apiResponse=new ApiResponse();
//	     apiResponse.setBody(null);
//	     apiResponse.setMessage(e.getMessage());
//	     apiResponse.setError(true);
//	     apiResponse.setStatus(HttpStatus.BAD_REQUEST);
//	     return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
//	}
		
	
	

	@ExceptionHandler(NoRequestPresentException.class)
	public ResponseEntity<Object> retrieveRequestsException(NoRequestPresentException exception) {
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setBody(exception.getMessage());
		apiResponse.setMessage("Request not found");
		apiResponse.setError(true);
		apiResponse.setStatus(HttpStatus.BAD_REQUEST);
		return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
	}

	@ExceptionHandler(NoSuchTokenPresentException.class)
	public ResponseEntity<Object> retrieveTokenDataException(NoSuchTokenPresentException exception) {
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setBody(exception.getMessage());
		apiResponse.setMessage("Token Not Found");
		apiResponse.setError(true);
		apiResponse.setStatus(HttpStatus.BAD_REQUEST);
		return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
	}
	@ExceptionHandler(ReIssueCountException.class)
	public ResponseEntity<Object> reissueCountHandler(Exception e,Throwable t) {
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setBody(e.getMessage());
		apiResponse.setMessage(e.getMessage());
		apiResponse.setError(true);
		apiResponse.setStatus(HttpStatus.BAD_REQUEST);
		return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
	}
	
	@ExceptionHandler(BookLimitExceededException.class)
	public ResponseEntity<Object> bookLimitExceptionHandle(Exception e,Throwable t) {
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setBody(e.getMessage());
		apiResponse.setMessage(e.getMessage());
		apiResponse.setError(true);
		apiResponse.setStatus(HttpStatus.BAD_REQUEST);
		return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
	}
	

}
