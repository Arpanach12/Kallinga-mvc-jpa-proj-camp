package com.mindtree.librarymanagementsystem.modules.book.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mindtree.librarymanagementsystem.modules.common.enums.BookStatus;
import com.mindtree.librarymanagementsystem.modules.feedback.entity.Feedback;

@Entity
@Table(name = "book")
public class Book {

	@Id
	private Long bookId;
	private String bookTitle;
	private Integer totalPages;
	private LocalDate publishDate;
	@Enumerated(EnumType.STRING)
	private BookStatus bookStatus;
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookTitle=" + bookTitle + ", totalPages=" + totalPages + ", publishDate="
				+ publishDate + ", bookStatus=" + bookStatus + ", bookImageUrl=" + bookImageUrl + ", totalBookCount="
				+ totalBookCount + ", availableBookCount=" + availableBookCount + ", bookRating=" + bookRating
				+ ", authors=" + authors + ", publisher=" + publisher + ", genre=" + genre + ", feedbacks=" + feedbacks
				+ "]";
	}

	private String bookImageUrl;
	private Integer totalBookCount;
	private Integer availableBookCount;
	private Float bookRating;

	
	@ManyToMany(mappedBy = "books",cascade = CascadeType.ALL)
	private List<Author> authors;
	
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})

	@JoinColumn(name = "publiser_id")
	private Publisher publisher;
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE })
	@JoinColumn(name = "genre_id")
	private Genre genre;
	@OneToMany(mappedBy = "book", cascade = { CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<Feedback> feedbacks = new HashSet<>();

	/**
	 * @param object7 
	 * @param object6 
	 * @param object5 
	 * @param object4 
	 * @param f 
	 * @param c 
	 * @param b 
	 * @param string2 
	 * @param object3 
	 * @param object2 
	 * @param object 
	 * @param string 
	 * @param l 
	 * 
	 */
	
	
	public Book(Long bookId, String bookTitle, Integer totalPages, LocalDate publishDate, BookStatus bookStatus,
			String bookImageUrl, Integer totalBookCount, Integer availableBookCount, Float bookRating,
			List<Author> authors, Publisher publisher, Genre genre, Set<Feedback> feedbacks) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.totalPages = totalPages;
		this.publishDate = publishDate;
		this.bookStatus = bookStatus;
		this.bookImageUrl = bookImageUrl;
		this.totalBookCount = totalBookCount;
		this.availableBookCount = availableBookCount;
		this.bookRating = bookRating;
		this.authors = authors;
		this.publisher = publisher;
		this.genre = genre;
		this.feedbacks = feedbacks;
	}



	public Book() {
		super();
	}



	/**
	 * @return the bookId
	 */
	public Long getBookId() {
		return bookId;
	}

	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	/**
	 * @return the bookTitle
	 */
	public String getBookTitle() {
		return bookTitle;
	}

	/**
	 * @param bookTitle the bookTitle to set
	 */
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	/**
	 * @return the totalPages
	 */
	public Integer getTotalPages() {
		return totalPages;
	}

	/**
	 * @param totalPages the totalPages to set
	 */
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	/**
	 * @return the publishDate
	 */
	public LocalDate getPublishDate() {
		return publishDate;
	}

	/**
	 * @param publishDate the publishDate to set
	 */
	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	/**
	 * @return the bookStatus
	 */
	public BookStatus getBookStatus() {
		return bookStatus;
	}

	/**
	 * @param bookStatus the bookStatus to set
	 */
	public void setBookStatus(BookStatus bookStatus) {
		this.bookStatus = bookStatus;
	}

	/**
	 * @return the bookImageUrl
	 */
	public String getBookImageUrl() {
		return bookImageUrl;
	}

	/**
	 * @param bookImageUrl the bookImageUrl to set
	 */
	public void setBookImageUrl(String bookImageUrl) {
		this.bookImageUrl = bookImageUrl;
	}

	/**
	 * @return the totalBookCount
	 */
	public Integer getTotalBookCount() {
		return totalBookCount;
	}

	/**
	 * @param totalBookCount the totalBookCount to set
	 */
	public void setTotalBookCount(Integer totalBookCount) {
		this.totalBookCount = totalBookCount;
	}

	/**
	 * @return the availableBookCount
	 */
	public Integer getAvailableBookCount() {
		return availableBookCount;
	}

	/**
	 * @param availableBookCount the availableBookCount to set
	 */
	public void setAvailableBookCount(Integer availableBookCount) {
		this.availableBookCount = availableBookCount;
	}

	/**
	 * @return the bookRating
	 */
	public Float getBookRating() {
		return bookRating;
	}

	/**
	 * @param bookRating the bookRating to set
	 */
	public void setBookRating(Float bookRating) {
		this.bookRating = bookRating;
	}

	/**
	 * @return the authors
	 */
	public List<Author> getAuthors() {
		return authors;
	}

	/**
	 * @param authors the authors to set
	 */
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	/**
	 * @return the publisher
	 */
	public Publisher getPublisher() {
		return publisher;
	}

	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	/**
	 * @return the genre
	 */
	public Genre getGenre() {
		return genre;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	/**
	 * @return the feedbacks
	 */
	public Set<Feedback> getFeedbacks() {
		return feedbacks;
	}

	/**
	 * @param feedbacks the feedbacks to set
	 */
	public void setFeedbacks(Set<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

}
