package com.mindtree.librarymanagementsystem.modules.user.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.librarymanagementsystem.modules.common.apiconfig.ApiResponse;
import com.mindtree.librarymanagementsystem.modules.user.exception.service.BookNotCurrentlyAvailable;
import com.mindtree.librarymanagementsystem.modules.user.exception.service.NoMoreReissue;
import com.mindtree.librarymanagementsystem.modules.user.service.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {


@Autowired
UserService userService;


//@PostMapping("/assignbookstomind/{issueId},{BookId1},{BookId2}")
//public ResponseEntity<ApiResponse> assigningBooksToMind(@PathVariable Long issueId,@PathVariable Long BookId1,@PathVariable Long BookId2) throws NoMoreReissue, BookNotCurrentlyAvailable 
//{
//	ApiResponse apiResponse = new ApiResponse();
//	apiResponse.setBody(userService.assignBooksToMind(issueId,BookId1,BookId2));
//	apiResponse.setMessage("assign book to user sucessfully");
//	apiResponse.setError(false);
//	apiResponse.setStatus(HttpStatus.CREATED);
//	apiResponse.setStatus(HttpStatus.FOUND);
//	return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
//}
@PreAuthorize("hasRole('ROLE_ADMIN')")
@PostMapping("/assignbookstomind/{issueId}")
public ResponseEntity<ApiResponse> assigningBooksToMind(@PathVariable Long issueId) throws NoMoreReissue, BookNotCurrentlyAvailable 
{
	ApiResponse apiResponse = new ApiResponse();
	apiResponse.setBody(userService.assignBooksToMindNew(issueId));
	apiResponse.setMessage("assign book to user sucessfully");
	apiResponse.setError(false);
	apiResponse.setStatus(HttpStatus.CREATED);
	apiResponse.setStatus(HttpStatus.FOUND);
	return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
}

@PreAuthorize("hasRole('ROLE_ADMIN')")
@PostMapping("/assignbookstomind/{issueId}/{BookId1}")
public ResponseEntity<ApiResponse> assigningBooksToMind(@PathVariable Long issueId,@PathVariable Long BookId1) throws NoMoreReissue, BookNotCurrentlyAvailable 
{
	ApiResponse apiResponse = new ApiResponse();
	apiResponse.setBody(userService.assignBooksToMind(issueId,BookId1));
	apiResponse.setMessage("assign book to user sucessfully");
	apiResponse.setError(false);
	apiResponse.setStatus(HttpStatus.CREATED);
	apiResponse.setStatus(HttpStatus.FOUND);
	return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
}


}
