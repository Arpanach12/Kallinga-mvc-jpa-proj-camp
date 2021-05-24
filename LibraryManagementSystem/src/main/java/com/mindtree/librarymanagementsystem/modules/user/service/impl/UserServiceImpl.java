package com.mindtree.librarymanagementsystem.modules.user.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.librarymanagementsystem.modules.book.entity.Book;
import com.mindtree.librarymanagementsystem.modules.book.repository.BookRepository;
import com.mindtree.librarymanagementsystem.modules.common.enums.TokenStatus;
import com.mindtree.librarymanagementsystem.modules.transaction.dto.IssueRecordDto;
import com.mindtree.librarymanagementsystem.modules.transaction.entity.IssueRecord;
import com.mindtree.librarymanagementsystem.modules.transaction.repository.IssueRecordRepository;
import com.mindtree.librarymanagementsystem.modules.user.exception.service.BookNotCurrentlyAvailable;
import com.mindtree.librarymanagementsystem.modules.user.exception.service.NoMoreReissue;
import com.mindtree.librarymanagementsystem.modules.user.repository.UserRepository;
import com.mindtree.librarymanagementsystem.modules.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private IssueRecordRepository issueRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public IssueRecordDto assignBooksToMind(Long issueId, Long bookId1, Long bookId2)
			throws NoMoreReissue, BookNotCurrentlyAvailable {
		Book book1 = bookRepository.findById(bookId1).get();
		Book book2 = bookRepository.findById(bookId2).get();
		IssueRecord issueRecord = issueRepository.findById(issueId).get();

		issueRepository.findById(issueId).filter(issue -> issue.getReIssueCount() < 2)
				.orElseThrow(() -> new NoMoreReissue("book can't be reissue more than twice"))
				.setReIssueCount((byte) (issueRecord.getReIssueCount() + 1));
		if (book1.getAvailableBookCount() > 0 && book2.getAvailableBookCount() > 0) {

			book1.setAvailableBookCount(book1.getAvailableBookCount() - 1);
			book2.setAvailableBookCount(book2.getAvailableBookCount() - 1);

		} else {

			throw new BookNotCurrentlyAvailable("this book is not currently available");
		}

		Set<Book> bookSet = new HashSet<Book>();
		bookSet.add(book1);
		bookSet.add(book2);
		issueRecord.setBooks(bookSet);

		issueRepository.save(issueRecord);
		return convertIssueRecordEntityToDto(issueRecord);
	}

	public IssueRecordDto convertIssueRecordEntityToDto(IssueRecord issueRecord) {

		return modelMapper.map(issueRecord, IssueRecordDto.class);
	}

	@Override
	public IssueRecordDto assignBooksToMind(Long issueId, Long bookId1)
			throws NoMoreReissue, BookNotCurrentlyAvailable {
		Book book1 = bookRepository.findById(bookId1).get();

		IssueRecord issueRecord = issueRepository.findById(issueId).get();

		issueRepository.findById(issueId).filter(issue -> issue.getReIssueCount() < 2)
				.orElseThrow(() -> new NoMoreReissue("book can't be reissue more than twice"))
				.setReIssueCount((byte) (issueRecord.getReIssueCount() + 1));
		if (book1.getAvailableBookCount() > 0) {
			book1.setAvailableBookCount(book1.getAvailableBookCount() - 1);
		} else {
			throw new BookNotCurrentlyAvailable("this book is not currently available");
		}

		Set<Book> bookSet = new HashSet<Book>();
		if (issueRecord.getBooks() == null) {
			bookSet.add(book1);
			issueRecord.setBooks(bookSet);
		} else {
			issueRecord.getBooks().add(book1);
		}
		issueRepository.saveAndFlush(issueRecord);

		return modelMapper.map(issueRecord, IssueRecordDto.class);
	}

	@Override
	public IssueRecordDto assignBooksToMindNew(Long issueId) throws BookNotCurrentlyAvailable, NoMoreReissue {

		IssueRecord issueRecord = issueRepository.findById(issueId).get();
		issueRepository.findById(issueId).filter(issue -> issue.getReIssueCount() < 2)
				.orElseThrow(() -> new NoMoreReissue("book can't be reissue more than twice"))
				.setReIssueCount((byte) (issueRecord.getReIssueCount() + 1));
		for (Book book : issueRecord.getBooks()) {
			if (book.getAvailableBookCount() > 0) {

				book.setAvailableBookCount(book.getAvailableBookCount() - 1);

			} else {

				throw new BookNotCurrentlyAvailable("this book is not currently available");
			}

		}
		issueRecord.setTokenStatus(TokenStatus.CONFIRM);
		issueRepository.saveAndFlush(issueRecord);
		return modelMapper.map(issueRecord, IssueRecordDto.class);

	}

}
