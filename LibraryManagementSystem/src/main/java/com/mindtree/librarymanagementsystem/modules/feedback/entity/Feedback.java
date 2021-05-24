package com.mindtree.librarymanagementsystem.modules.feedback.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mindtree.librarymanagementsystem.modules.book.entity.Book;
import com.mindtree.librarymanagementsystem.modules.user.entity.User;

@Entity
@Table(name="feedback")
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long feedbackId;
	private String feedbackComment;
	private Float feedbackRating;
	private LocalDate feedbackDate;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
	
    public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Feedback(Long feedbackId, String feedbackComment, Float feedbackRating, LocalDate feedbackDate, Book book,
			User user) {
		super();
		this.feedbackId = feedbackId;
		this.feedbackComment = feedbackComment;
		this.feedbackRating = feedbackRating;
		this.feedbackDate = feedbackDate;
		this.book = book;
		this.user = user;
	}

	public Long getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(Long feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getFeedbackComment() {
		return feedbackComment;
	}

	public void setFeedbackComment(String feedbackComment) {
		this.feedbackComment = feedbackComment;
	}

	public Float getFeedbackRating() {
		return feedbackRating;
	}

	public void setFeedbackRating(Float feedbackRating) {
		this.feedbackRating = feedbackRating;
	}

	public LocalDate getFeedbackDate() {
		return feedbackDate;
	}

	public void setFeedbackDate(LocalDate feedbackDate) {
		this.feedbackDate = feedbackDate;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", feedbackComment=" + feedbackComment + ", feedbackRating="
				+ feedbackRating + ", feedbackDate=" + feedbackDate + ", book=" + book + ", user=" + user + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((feedbackComment == null) ? 0 : feedbackComment.hashCode());
		result = prime * result + ((feedbackDate == null) ? 0 : feedbackDate.hashCode());
		result = prime * result + ((feedbackId == null) ? 0 : feedbackId.hashCode());
		result = prime * result + ((feedbackRating == null) ? 0 : feedbackRating.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Feedback other = (Feedback) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (feedbackComment == null) {
			if (other.feedbackComment != null)
				return false;
		} else if (!feedbackComment.equals(other.feedbackComment))
			return false;
		if (feedbackDate == null) {
			if (other.feedbackDate != null)
				return false;
		} else if (!feedbackDate.equals(other.feedbackDate))
			return false;
		if (feedbackId == null) {
			if (other.feedbackId != null)
				return false;
		} else if (!feedbackId.equals(other.feedbackId))
			return false;
		if (feedbackRating == null) {
			if (other.feedbackRating != null)
				return false;
		} else if (!feedbackRating.equals(other.feedbackRating))
			return false;
		return true;
	}
    
    
    
	
	
}
