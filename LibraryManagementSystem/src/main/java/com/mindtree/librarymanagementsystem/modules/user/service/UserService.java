package com.mindtree.librarymanagementsystem.modules.user.service;

import com.mindtree.librarymanagementsystem.modules.transaction.dto.IssueRecordDto;
import com.mindtree.librarymanagementsystem.modules.user.exception.service.BookNotCurrentlyAvailable;
import com.mindtree.librarymanagementsystem.modules.user.exception.service.NoMoreReissue;

public interface UserService {

	/**
	 * @param userId
	 * @param bookId1
	 * @param bookId2
	 * @return response in form issue dto
	 * @throws NoMoreReissue
	 * @throws BookNotCurrentlyAvailable
	 * issuing two books at a time or reissue two book at the time
	 */
	IssueRecordDto assignBooksToMind(Long userId, Long bookId1, Long bookId2) throws NoMoreReissue, BookNotCurrentlyAvailable ;

	/**
	 * @param issueId
	 * @param bookId1
	 * @return response in form of dto
	 * @throws NoMoreReissue
	 * @throws BookNotCurrentlyAvailable
	 * for issueing only one book or reissue only one book
	 */
	IssueRecordDto assignBooksToMind(Long issueId, Long bookId1) throws NoMoreReissue, BookNotCurrentlyAvailable;

	IssueRecordDto assignBooksToMindNew(Long issueId) throws BookNotCurrentlyAvailable, NoMoreReissue;

}
