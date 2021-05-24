package com.mindtree.librarymanagementsystem.modules.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mindtree.librarymanagementsystem.modules.book.dto.AuthorDto;
import com.mindtree.librarymanagementsystem.modules.book.dto.BookDateDto;
import com.mindtree.librarymanagementsystem.modules.book.dto.BookDto;
import com.mindtree.librarymanagementsystem.modules.book.dto.GenreDto;
import com.mindtree.librarymanagementsystem.modules.book.dto.PublisherDto;
import com.mindtree.librarymanagementsystem.modules.book.entity.Author;
import com.mindtree.librarymanagementsystem.modules.book.entity.Book;
import com.mindtree.librarymanagementsystem.modules.book.entity.Genre;
import com.mindtree.librarymanagementsystem.modules.book.entity.Publisher;

import com.mindtree.librarymanagementsystem.modules.feedback.dto.FeedbackDto;
import com.mindtree.librarymanagementsystem.modules.feedback.entity.Feedback;

import com.mindtree.librarymanagementsystem.modules.transaction.dto.IssueRecordDto;
import com.mindtree.librarymanagementsystem.modules.transaction.entity.IssueRecord;
import com.mindtree.librarymanagementsystem.modules.user.dto.UserDto;
import com.mindtree.librarymanagementsystem.modules.user.entity.User;

@Component
public class Util {

	@Autowired
	private ModelMapper modelMapper;

	public Book convertDtoToBookEntity(BookDto bookDto) {
		return modelMapper.map(bookDto, Book.class);
	}

	public UserDto convertUserEntityToDto(User user) {

		return modelMapper.map(user, UserDto.class);
	}

	public User convertDtoToUserEntity(UserDto userDto) {
		return modelMapper.map(userDto, User.class);
	}
	
	public BookDto convertBookEntityToDto(Book book) {

		return modelMapper.map(book, BookDto.class);
	}

	public BookDateDto convertBookEntityToBookDateDto(Book book) {
		return modelMapper.map(book, BookDateDto.class);
	}

	public Book convertBookEntityToBookDateDto(BookDateDto bookDateDto) {
		return modelMapper.map(bookDateDto, Book.class);
	}

	public AuthorDto convertAuthorEntityToDto(Author author) {

		return modelMapper.map(author, AuthorDto.class);

	}

	public PublisherDto convertPublisherEntityToDto(Publisher publisher) {

		return modelMapper.map(publisher, PublisherDto.class);

	}

	public GenreDto convertGenreEntityToDto(Genre genre) {

		return modelMapper.map(genre, GenreDto.class);

	}

	public FeedbackDto convertFeedbackEntityToDto(Feedback feedback) {

		return modelMapper.map(feedback, FeedbackDto.class);
	}

	public Feedback convertFeedbackDtoToEntity(FeedbackDto feedbackdto) {

		return modelMapper.map(feedbackdto, Feedback.class);
	}

	public IssueRecordDto convertIssueRecordEntityToDto(IssueRecord issueRecord) {
		return modelMapper.map(issueRecord, IssueRecordDto.class);
	}

	public IssueRecord convertDtoToIssueRecordEntity(IssueRecordDto issueRecordDto) {
		return modelMapper.map(issueRecordDto, IssueRecord.class);
	}
	
	

}
