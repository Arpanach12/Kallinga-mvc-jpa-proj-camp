package com.mindtree.librarymanagementsystem.modules.transaction.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.mail.MessagingException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.librarymanagementsystem.modules.book.entity.Book;
import com.mindtree.librarymanagementsystem.modules.book.exception.service.BookNotFoundException;
import com.mindtree.librarymanagementsystem.modules.book.exception.service.BookServiceException;
import com.mindtree.librarymanagementsystem.modules.book.exception.service.NoSuchBookIdException;
import com.mindtree.librarymanagementsystem.modules.book.repository.BookRepository;
import com.mindtree.librarymanagementsystem.modules.common.enums.TokenStatus;
import com.mindtree.librarymanagementsystem.modules.common.exceptions.RecordNotFoundException;
import com.mindtree.librarymanagementsystem.modules.transaction.dto.IssueRecordDto;
import com.mindtree.librarymanagementsystem.modules.transaction.entity.IssueRecord;
import com.mindtree.librarymanagementsystem.modules.transaction.exception.serviceexception.BookLimitExceededException;
import com.mindtree.librarymanagementsystem.modules.transaction.exception.serviceexception.IssueRecordDoesNotExistException;
import com.mindtree.librarymanagementsystem.modules.transaction.exception.serviceexception.NoBookIssuedException;
import com.mindtree.librarymanagementsystem.modules.transaction.exception.serviceexception.NoRequestPresentException;

import com.mindtree.librarymanagementsystem.modules.transaction.exception.serviceexception.ReIssueCountException;

import com.mindtree.librarymanagementsystem.modules.transaction.exception.serviceexception.NoSuchTokenPresentException;
import com.mindtree.librarymanagementsystem.modules.transaction.exception.serviceexception.RequestLimitExceededException;

import com.mindtree.librarymanagementsystem.modules.transaction.exception.serviceexception.TransactionServiceException;
import com.mindtree.librarymanagementsystem.modules.transaction.repository.IssueRecordRepository;
import com.mindtree.librarymanagementsystem.modules.transaction.service.IssueRecordService;
import com.mindtree.librarymanagementsystem.modules.transaction.service.MailService;
import com.mindtree.librarymanagementsystem.modules.user.entity.User;
import com.mindtree.librarymanagementsystem.modules.user.exception.service.NoSuchUserIdException;
import com.mindtree.librarymanagementsystem.modules.user.repository.UserRepository;
import com.mindtree.librarymanagementsystem.modules.util.Util;

@Service
public class IssueRecordServiceImpl implements IssueRecordService {

	@Autowired
	private IssueRecordRepository issueRecordRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private Util util;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private MailService mailService;

	@Override
	public IssueRecordDto getIssueRecord(Long issueRecordId) throws TransactionServiceException {
		return util.convertIssueRecordEntityToDto(issueRecordRepository.findByIssueId(issueRecordId)
				.orElseThrow(() -> new IssueRecordDoesNotExistException("Issue Record Does Not Exist")));
	}

	@Override
	public IssueRecordDto changeIssueRecordStatus(TokenStatus tokenStatus, Long issueRecordId, Long approverId)
			throws TransactionServiceException, BookServiceException, MessagingException {
		IssueRecord issueRecordObj = issueRecordRepository.findById(issueRecordId)
				.orElseThrow(() -> new IssueRecordDoesNotExistException("Issue Record Does Not Exist"));
		issueRecordObj.setTokenStatus(tokenStatus);
		issueRecordObj.setApprovedBy(userRepository.getOne(approverId));
		if (tokenStatus.equals(TokenStatus.CONFIRM)) {
			for (Book bookObj : issueRecordObj.getBooks()) {
				Book book = bookRepository.getOne(bookObj.getBookId());

				if (book.getAvailableBookCount() == 0) {
					throw new BookNotFoundException("Book not available");
				}
				book.setAvailableBookCount(book.getAvailableBookCount() - 1);
				bookRepository.saveAndFlush(book);

			}
			 //mailService.sendNotification(issueRecordObj);
			mailService.sendEmailWithAttachment(issueRecordObj);

		}

		if (tokenStatus.equals(TokenStatus.CLOSE)) {
			if (issueRecordObj.getTokenStatus().equals(TokenStatus.OPEN)) {
				issueRecordObj.setTokenStatus(TokenStatus.CLOSE);

			} else {

				for (Book bookObj : issueRecordObj.getBooks()) {
					Book book = bookRepository.getOne(bookObj.getBookId());
                   	book.setAvailableBookCount(book.getAvailableBookCount() + 1);
					bookRepository.saveAndFlush(book);
				}

			}
			//mailService.sendNotification(issueRecordObj);
			mailService.sendEmailWithAttachment(issueRecordObj);
		}

		return util.convertIssueRecordEntityToDto(issueRecordRepository.saveAndFlush(issueRecordObj));

	}

	@Override
	public Set<IssueRecordDto> retrieveAllRequests() throws TransactionServiceException {

		List<IssueRecord> issueRecords = new ArrayList<IssueRecord>();
		Set<IssueRecordDto> issueRecordDtos = new HashSet<IssueRecordDto>();
		issueRecords = issueRecordRepository.findAll();
		if (issueRecords.isEmpty())
			throw new NoRequestPresentException("No Requests Present");

		issueRecordDtos = issueRecords.stream().map(issue -> util.convertIssueRecordEntityToDto(issue))
				.collect(Collectors.toSet());
		return issueRecordDtos;

	}

	@Override

	public String getReIssueRecord(Long issueRecordId) throws TransactionServiceException {
		IssueRecord issueRecord = issueRecordRepository.findById(issueRecordId).get();
		LocalDate oldreturnDate = issueRecord.getReturnDate();
		LocalDate newreturnDate;
		if (issueRecord.getReIssueCount() == 0) {
			if (issueRecord.getTokenStatus().equals(TokenStatus.CONFIRM)) {
				newreturnDate = oldreturnDate.plusDays(10);
				System.out.println(newreturnDate);
				issueRecord.setReturnDate(newreturnDate);
			} else {
				throw new IssueRecordDoesNotExistException("Issue Record Does Not Exist");
			}
		} else {
			throw new ReIssueCountException("cannot be reissued");
		}

		byte reissueCount = issueRecord.getReIssueCount();

		issueRecord.setReIssueCount((byte) (reissueCount + 1));

		issueRecordRepository.save(issueRecord);

		return "reissued successfully";
	}

	public IssueRecordDto retrieveTokenData(Long tokenId) throws TransactionServiceException {
		if (!issueRecordRepository.existsByTokenId(tokenId))
			throw new NoSuchTokenPresentException("Token Not Found");
		return util.convertIssueRecordEntityToDto(issueRecordRepository.findByTokenId(tokenId));

	}

	@Override
	public Set<IssueRecordDto> getAllIssueForUser(String mindId) throws TransactionServiceException {

		User user = userRepository.findByusername(mindId).get();
		System.out.println(user.getUserName());
		if (user.getIssueRecords().size() == 0)
			throw new NoBookIssuedException("No book issued");

		return issueRecordRepository.findAll().stream().map(issue -> util.convertIssueRecordEntityToDto(issue))
				.filter(issue -> issue.getUser().getUserName().equalsIgnoreCase(mindId)).collect(Collectors.toSet());

	}

	@Override
	public IssueRecordDto generateRequest(long userId, List<Long> bookId)
			throws RecordNotFoundException, TransactionServiceException {

		Optional<User> optionalUser = userRepository.findById(userId);
		optionalUser.orElseThrow(() -> new NoSuchUserIdException("No Such User Id is present in DB"));

		User user = optionalUser.get();

		int noOfBooks = 0;
		int issuRecordCounter = 0;
		for (IssueRecord tempIssueRecord : user.getIssueRecords()) {
			if (!tempIssueRecord.getTokenStatus().equals(TokenStatus.CLOSE)) {
				issuRecordCounter++;
				noOfBooks = noOfBooks + tempIssueRecord.getBooks().size();
			}
		}

		if (issuRecordCounter >= 2) {
			throw new RequestLimitExceededException("Can't Raise !! User Has 2 requests !!");
		}

		if (noOfBooks >= 2) {
			throw new BookLimitExceededException("user has 2 pending  books !!");
		}
		Set<Book> books = new HashSet<Book>();
		for (Long long1 : bookId) {
			Optional<Book> optionalBook = bookRepository.findById(long1);
			optionalBook.orElseThrow(() -> new NoSuchBookIdException("No such Book ID present"));
			books.add(optionalBook.get());
		}

		IssueRecord issueRecord = new IssueRecord();
		issueRecord.setUser(user);
		issueRecord.setBooks(books);

		issueRecord.setIssueDate(LocalDate.now());

		LocalDate returnDate = LocalDate.now().plusDays(10);
		issueRecord.setReturnDate(returnDate);

		issueRecord.setReIssueCount((byte) 0);

		issueRecord.setTokenStatus(TokenStatus.OPEN);

		return util.convertIssueRecordEntityToDto(issueRecordRepository.save(issueRecord));
	}

}
