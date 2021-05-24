package com.mindtree.librarymanagementsystem.modules.feedback.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.librarymanagementsystem.modules.book.entity.Book;
import com.mindtree.librarymanagementsystem.modules.book.exception.service.NoSuchBookIdException;
import com.mindtree.librarymanagementsystem.modules.book.repository.BookRepository;
import com.mindtree.librarymanagementsystem.modules.common.exceptions.LMSServiceException;
import com.mindtree.librarymanagementsystem.modules.feedback.dto.FeedbackDto;
import com.mindtree.librarymanagementsystem.modules.feedback.entity.Feedback;
import com.mindtree.librarymanagementsystem.modules.feedback.repository.FeedbackRepository;
import com.mindtree.librarymanagementsystem.modules.feedback.service.FeedbackService;
import com.mindtree.librarymanagementsystem.modules.user.entity.User;
import com.mindtree.librarymanagementsystem.modules.user.exception.service.NoSuchUserIdException;
import com.mindtree.librarymanagementsystem.modules.user.repository.UserRepository;
import com.mindtree.librarymanagementsystem.modules.util.Util;

@Service
public class FeedbackServiceImpl implements FeedbackService {
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private FeedbackRepository feedbackRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private Util util;

	@Override
	public FeedbackDto addcommentsForTheBook(long bookId, FeedbackDto feedbackDto, long userId)
			throws LMSServiceException {

		Optional<Book> optionalBook = bookRepository.findById(bookId);
		optionalBook.orElseThrow(() -> new NoSuchBookIdException("NO Such Book Id present"));

		Optional<User> optionalUser = userRepository.findById(userId);
		optionalUser.orElseThrow(() -> new NoSuchUserIdException("No Such User Id Present"));

		Book book = optionalBook.get();
		User user = optionalUser.get();
		Feedback feedback = util.convertFeedbackDtoToEntity(feedbackDto);
		float avgRating = 0.0f;
		if (book.getBookRating() == null) {
			avgRating = feedback.getFeedbackRating();
		} else {
			avgRating = (book.getBookRating() + feedback.getFeedbackRating()) / (2);
		}

		book.setBookRating(avgRating);
		feedback.setUser(user);
		feedback.setBook(book);
		feedbackRepository.save(feedback);
		return util.convertFeedbackEntityToDto(feedback);
	}

}
