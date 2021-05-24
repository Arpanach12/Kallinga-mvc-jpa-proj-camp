package com.mindtree.librarymanagementsystem.modules.feedback.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mindtree.librarymanagementsystem.modules.book.dto.BookDto;
import com.mindtree.librarymanagementsystem.modules.user.dto.UserDto;

public class FeedbackDto {

	private Long feedbackId;
	private String feedbackComment;
	private Float feedbackRating;
	private LocalDate feedbackDate;

	@JsonIgnoreProperties({ "authors", "publisher", "genre" })
	private BookDto book;

	@JsonIgnoreProperties({ "feedbacks", "password", "issueRecords" })

	private UserDto user;


	public FeedbackDto(Long feedbackId, String feedbackComment, Float feedbackRating, LocalDate feedbackDate,
			BookDto book, UserDto user) {
		super();
		this.feedbackId = feedbackId;
		this.feedbackComment = feedbackComment;
		this.feedbackRating = feedbackRating;
		this.feedbackDate = feedbackDate;
		this.book = book;
		this.user = user;
	}

	public FeedbackDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the feedbackId
	 */
	public Long getFeedbackId() {
		return feedbackId;
	}

	/**
	 * @param feedbackId the feedbackId to set
	 */
	public void setFeedbackId(Long feedbackId) {
		this.feedbackId = feedbackId;
	}

	/**
	 * @return the feedbackComment
	 */
	public String getFeedbackComment() {
		return feedbackComment;
	}

	/**
	 * @param feedbackComment the feedbackComment to set
	 */
	public void setFeedbackComment(String feedbackComment) {
		this.feedbackComment = feedbackComment;
	}

	/**
	 * @return the feedbackRating
	 */
	public Float getFeedbackRating() {
		return feedbackRating;
	}

	/**
	 * @param feedbackRating the feedbackRating to set
	 */
	public void setFeedbackRating(Float feedbackRating) {
		this.feedbackRating = feedbackRating;
	}

	/**
	 * @return the feedbackDate
	 */
	public LocalDate getFeedbackDate() {
		return feedbackDate;
	}

	/**
	 * @param feedbackDate the feedbackDate to set
	 */
	public void setFeedbackDate(LocalDate feedbackDate) {
		this.feedbackDate = feedbackDate;
	}

	/**
	 * @return the book
	 */
	public BookDto getBook() {
		return book;
	}

	/**
	 * @param book the book to set
	 */
	public void setBook(BookDto book) {
		this.book = book;
	}

	/**
	 * @return the user
	 */
	public UserDto getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(UserDto user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "FeedbackDto [feedbackId=" + feedbackId + ", feedbackComment=" + feedbackComment + ", feedbackRating="
				+ feedbackRating + ", feedbackDate=" + feedbackDate + ", book=" + book + ", user=" + user + "]";
	}

}
