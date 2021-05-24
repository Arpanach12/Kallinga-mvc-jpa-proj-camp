package com.mindtree.librarymanagementsystem.modules.transaction.service;

import java.util.List;
import java.util.Set;

import javax.mail.MessagingException;

import com.mindtree.librarymanagementsystem.modules.book.exception.service.BookServiceException;
import com.mindtree.librarymanagementsystem.modules.common.enums.TokenStatus;
import com.mindtree.librarymanagementsystem.modules.common.exceptions.RecordNotFoundException;
import com.mindtree.librarymanagementsystem.modules.transaction.dto.IssueRecordDto;
import com.mindtree.librarymanagementsystem.modules.transaction.exception.serviceexception.TransactionServiceException;

public interface IssueRecordService {

	/**
	 * @return issueRecords
	 * @throws TransactionServiceException
	 */
	public Set<IssueRecordDto> retrieveAllRequests() throws TransactionServiceException;

	/**
	 * @param issueRecordId
	 * @return IssueRecord
	 * @throws TransactionServiceException
	 */
	public IssueRecordDto getIssueRecord(Long issueRecordId) throws TransactionServiceException;

	/**
	 * @param tokenStatus
	 * @param issueRecordId
	 * @param approverId
	 * @return IssueRecord
	 * @throws TransactionServiceException
	 * @throws BookServiceException
	 * @throws MessagingException 
	 */
	public IssueRecordDto changeIssueRecordStatus(TokenStatus tokenStatus, Long issueRecordId, Long approverId)
			throws TransactionServiceException, BookServiceException, MessagingException;

	/**
	 * @param issueRecordId
	 * @return String
	 * @throws TransactionServiceException
	 */
	public String getReIssueRecord(Long issueRecordId) throws TransactionServiceException;

	/**
	 * @param userId
	 * @param bookId
	 * @return IssueRecordDto
	 * @throws RecordNotFoundException
	 * @throws TransactionServiceException
	 */
	public IssueRecordDto generateRequest(long userId, List<Long> bookId)
			throws RecordNotFoundException, TransactionServiceException;

	/**
	 * @param mindId
	 * @return issueRecords
	 * @throws TransactionServiceException
	 */
	public Set<IssueRecordDto> getAllIssueForUser(String mindId) throws TransactionServiceException;

	/**
	 * @param tokenId
	 * @return issueRecord
	 * @throws TransactionServiceException
	 */
	public IssueRecordDto retrieveTokenData(Long tokenId) throws TransactionServiceException;

}
