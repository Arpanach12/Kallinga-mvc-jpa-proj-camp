package com.mindtree.librarymanagementsystem.modules.book.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mindtree.librarymanagementsystem.modules.book.controller.BookController;

import com.mindtree.librarymanagementsystem.modules.book.exception.service.BookServiceException;
import com.mindtree.librarymanagementsystem.modules.book.exception.service.BookValidationException;
import com.mindtree.librarymanagementsystem.modules.book.exception.service.GenreNotFoundException;
import com.mindtree.librarymanagementsystem.modules.book.exception.service.NoOverDueRecordFound;
import com.mindtree.librarymanagementsystem.modules.book.exception.service.PublisherNotFoundException;
import com.mindtree.librarymanagementsystem.modules.book.exception.service.AuthorNotFoundException;
import com.mindtree.librarymanagementsystem.modules.book.exception.service.BookAlreadyExistsException;
import com.mindtree.librarymanagementsystem.modules.book.exception.service.BookNotFoundException;
import com.mindtree.librarymanagementsystem.modules.common.apiconfig.ApiResponse;

@RestControllerAdvice(assignableTypes = {BookController.class})
public class BookControllerHandler extends BookServiceException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponse> globalExceptionHandler(Exception e,Throwable t){
		ApiResponse apiResponse=new ApiResponse();
		apiResponse.setBody(null);
		apiResponse.setError(true);
		apiResponse.setStatus(HttpStatus.BAD_REQUEST);
		apiResponse.setMessage(e.getLocalizedMessage());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
				
	}

	@ExceptionHandler(NoOverDueRecordFound.class)
	public ResponseEntity<ApiResponse> NoOverDueRecordExceptionHandler1(Exception e,Throwable t){
		ApiResponse apiResponse=new ApiResponse();
		apiResponse.setBody(null);
		apiResponse.setError(true);
		apiResponse.setStatus(HttpStatus.BAD_REQUEST);
		apiResponse.setMessage(e.getMessage());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
				
	}
	@ExceptionHandler(BookAlreadyExistsException.class)
	public ResponseEntity<ApiResponse> bookAlreadyExistsHandler(Exception e,Throwable t){
		ApiResponse apiResponse=new ApiResponse();
		apiResponse.setBody(null);
		apiResponse.setError(true);
		apiResponse.setStatus(HttpStatus.BAD_REQUEST);
		apiResponse.setMessage(e.getMessage());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);

	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> validationError(MethodArgumentNotValidException e)
	{
		Map<String,String> errors=new HashMap<>();
		e.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName=((FieldError) error).getField();
			String errorMessage=error.getDefaultMessage();
			errors.put(fieldName,errorMessage);
		});
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}
	
	@ExceptionHandler(BookValidationException.class)
	public ResponseEntity<ApiResponse> bookValidationHandler(Exception e,Throwable t){
		ApiResponse apiResponse=new ApiResponse();
		apiResponse.setBody(null);
		apiResponse.setError(true);
		apiResponse.setStatus(HttpStatus.BAD_REQUEST);
		apiResponse.setMessage(e.getMessage());	
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
	}
	@ExceptionHandler(AuthorNotFoundException.class)
	public ResponseEntity<ApiResponse> GlobalAuthorExceptionHandler(Exception e) {

		ApiResponse apiResponse = new ApiResponse();

		apiResponse.setBody(e.getMessage());
		apiResponse.setMessage("Search Unsuccessfull");
		apiResponse.setError(true);
		apiResponse.setStatus(HttpStatus.BAD_REQUEST);
		return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

	}

	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<ApiResponse> GlobalBookExceptionHandler(Exception e) {

		ApiResponse apiResponse = new ApiResponse();

		apiResponse.setBody(e.getMessage());
		apiResponse.setMessage("Search Unsuccessfull");
		apiResponse.setError(true);
		apiResponse.setStatus(HttpStatus.BAD_REQUEST);
		return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

	}

	@ExceptionHandler(PublisherNotFoundException.class)
	public ResponseEntity<ApiResponse> GlobalPublisherExceptionHandler(Exception e) {

		ApiResponse apiResponse = new ApiResponse();

		apiResponse.setBody(e.getMessage());
		apiResponse.setMessage("Search Unsuccessfull");
		apiResponse.setError(true);
		apiResponse.setStatus(HttpStatus.BAD_REQUEST);
		return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

	}

	@ExceptionHandler(GenreNotFoundException.class)
	public ResponseEntity<ApiResponse> GlobalGenreExceptionHandler(Exception e) {

		ApiResponse apiResponse = new ApiResponse();

		apiResponse.setBody(e.getMessage());
		apiResponse.setMessage("Search Unsuccessfull");
		apiResponse.setError(true);
		apiResponse.setStatus(HttpStatus.BAD_REQUEST);
		return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

	}
	
}
