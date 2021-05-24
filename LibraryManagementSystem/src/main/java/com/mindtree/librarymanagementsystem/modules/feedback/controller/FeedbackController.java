package com.mindtree.librarymanagementsystem.modules.feedback.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mindtree.librarymanagementsystem.modules.common.apiconfig.ApiResponse;
import com.mindtree.librarymanagementsystem.modules.common.exceptions.LMSServiceException;
import com.mindtree.librarymanagementsystem.modules.feedback.dto.FeedbackDto;
import com.mindtree.librarymanagementsystem.modules.feedback.service.FeedbackService;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin("*")
public class FeedbackController {

@Autowired
FeedbackService feedbackService;

/**
 * @param bookId
 * @param userId
 * @param feedbackDto
 * @return ResponseEntity<ApiResponse>
 * @throws LMSServiceException 
 */	
@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
@PostMapping("/comment/{bookId}/{userId}")
public ResponseEntity<ApiResponse> addcommentsForTheBook(@PathVariable long bookId,@PathVariable long userId,@RequestBody FeedbackDto feedbackDto) throws LMSServiceException
{
    ApiResponse apiResponse = new ApiResponse();
	apiResponse.setBody(feedbackService.addcommentsForTheBook(bookId,feedbackDto,userId));
	apiResponse.setMessage("assign book to user sucessfully");
	apiResponse.setError(false);
	apiResponse.setStatus(HttpStatus.CREATED);
	apiResponse.setStatus(HttpStatus.FOUND);
	return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
}


	
}
