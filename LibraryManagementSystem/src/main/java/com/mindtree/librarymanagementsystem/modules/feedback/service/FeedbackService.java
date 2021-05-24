package com.mindtree.librarymanagementsystem.modules.feedback.service;

import com.mindtree.librarymanagementsystem.modules.common.exceptions.LMSServiceException;
import com.mindtree.librarymanagementsystem.modules.feedback.dto.FeedbackDto;

public interface FeedbackService {

	/**
	 * @param bookId
	 * @param feedbackDto
	 * @param userId
	 * @return FeedbackDto
	 * @throws LMSServiceException
	 */
	FeedbackDto addcommentsForTheBook(long bookId, FeedbackDto feedbackDto, long userId) throws LMSServiceException;

}
