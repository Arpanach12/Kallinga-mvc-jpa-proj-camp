package com.mindtree.librarymanagementsystem.modules.transaction.controller;

import java.util.List;
import java.util.Set;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.librarymanagementsystem.modules.book.exception.service.BookServiceException;
import com.mindtree.librarymanagementsystem.modules.common.apiconfig.ApiResponse;
import com.mindtree.librarymanagementsystem.modules.common.enums.TokenStatus;
import com.mindtree.librarymanagementsystem.modules.common.exceptions.LMSServiceException;
import com.mindtree.librarymanagementsystem.modules.transaction.dto.IssueRecordDto;
import com.mindtree.librarymanagementsystem.modules.transaction.exception.serviceexception.TransactionServiceException;
import com.mindtree.librarymanagementsystem.modules.transaction.service.IssueRecordService;

@RestController
@RequestMapping("api/transaction")
@CrossOrigin("*")
public class IssueRecordController {

	@Autowired
	private IssueRecordService issueRecordService;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/issuerecorddetails")
	public ResponseEntity<ApiResponse> getIssueRecord(@RequestParam Long issueRecordId)
			throws TransactionServiceException {
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setBody(issueRecordService.getIssueRecord(issueRecordId));
		apiResponse.setError(false);
		apiResponse.setSuccess(true);
		apiResponse.setStatus(HttpStatus.OK);
		return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/changeissuerecordstatus")
	public ResponseEntity<ApiResponse> changeIssueRecordStatus(@RequestParam TokenStatus tokenStatus,
			@RequestParam Long issueRecordId, @RequestParam Long approverId)
			throws TransactionServiceException, BookServiceException, MessagingException {
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setBody(issueRecordService.changeIssueRecordStatus(tokenStatus, issueRecordId, approverId));
		apiResponse.setError(false);
		apiResponse.setSuccess(true);
		apiResponse.setStatus(HttpStatus.OK);
		return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/issuerecords")
	public ResponseEntity<ApiResponse> displayAllRequests() throws TransactionServiceException {
		ApiResponse apiResponse = new ApiResponse();
		Set<IssueRecordDto> issueRecordDtos = issueRecordService.retrieveAllRequests();
		apiResponse.setBody(issueRecordDtos);
		apiResponse.setMessage("Requests Present");
		apiResponse.setError(false);
		apiResponse.setStatus(HttpStatus.FOUND);
		return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

	}
	// reissue the book
	@PreAuthorize("hasRole('ROLE_USER')")
	@PostMapping("/reissuerecorddetails")
	public ResponseEntity<ApiResponse> reissuerecorddetails(@RequestParam Long issueRecordId)
			throws TransactionServiceException {
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setBody(issueRecordService.getReIssueRecord(issueRecordId));
		apiResponse.setError(false);
		apiResponse.setSuccess(true);
		apiResponse.setStatus(HttpStatus.OK);
		return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
	}

	@PreAuthorize("hasRole('ROLE_USER')")
	@PostMapping("/raiserequest")
	public ResponseEntity<ApiResponse> raiseRequest(@RequestParam("userId" ) long userId,
			@RequestParam List<Long> bookId )
			throws LMSServiceException, TransactionServiceException {

		ApiResponse apiResponse = new ApiResponse();
		IssueRecordDto issueRecordDto = issueRecordService.generateRequest(userId, bookId);
		apiResponse.setBody(issueRecordDto);
		apiResponse.setMessage("Request Raised !!");
		apiResponse.setSuccess(true);
		apiResponse.setError(false);
		apiResponse.setStatus(HttpStatus.CREATED);

		return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

	}

	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/issuesforuser/{mindId}")
	public ResponseEntity<ApiResponse> displayAllIssues(@PathVariable String mindId)
			throws TransactionServiceException {
		ApiResponse apiResponse = new ApiResponse();
		Set<IssueRecordDto> issueRecordDtos = issueRecordService.getAllIssueForUser(mindId);
		apiResponse.setBody(issueRecordDtos);
		apiResponse.setMessage("Requests Present");
		apiResponse.setError(false);
		apiResponse.setStatus(HttpStatus.FOUND);
		return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

	}

	@PreAuthorize("hasAnyRole('ROLE_USER',ROLE_ADMIN)")
	@GetMapping("/issuerecord/tokenData")
	public ResponseEntity<ApiResponse> displayTokenData(@RequestParam Long tokenId) throws TransactionServiceException {
		ApiResponse apiResponse = new ApiResponse();
		IssueRecordDto issueRecordDto = issueRecordService.retrieveTokenData(tokenId);
		apiResponse.setBody(issueRecordDto);
		apiResponse.setMessage("Token Data Found");
		apiResponse.setError(false);
		apiResponse.setStatus(HttpStatus.FOUND);
		return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

	}

}
