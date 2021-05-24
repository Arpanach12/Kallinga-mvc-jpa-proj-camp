package com.mindtree.librarymanagementsystem.modules.book.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mindtree.librarymanagementsystem.modules.common.enums.BookStatus;

public class BookDateDto {
	private Long bookId;
	private LocalDate availableDate;
	private String bookTitle;
	private Integer totalPages;
	private LocalDate publishDate;
	private BookStatus bookStatus;
	private String bookImageUrl;
	private Integer totalBookCount;
	private Integer availableBookCount;
	private Float bookRating;
	@JsonIgnoreProperties("books")
	private List<AuthorDto> authors;
	@JsonIgnoreProperties("books")
	private PublisherDto publisher;
	@JsonIgnoreProperties("books")
	private GenreDto genre;

	public BookDateDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param bookId
	 * @param availableDate
	 * @param bookTitle
	 * @param totalPages
	 * @param publishDate
	 * @param bookStatus
	 * @param bookImageUrl
	 * @param totalBookCount
	 * @param availableBookCount
	 * @param bookRating
	 * @param authors
	 * @param publisher
	 * @param genre
	 */
	public BookDateDto(Long bookId, LocalDate availableDate, String bookTitle, Integer totalPages,
			LocalDate publishDate, BookStatus bookStatus, String bookImageUrl, Integer totalBookCount,
			Integer availableBookCount, Float bookRating, List<AuthorDto> authors, PublisherDto publisher,
			GenreDto genre) {
		super();
		this.bookId = bookId;
		this.availableDate = availableDate;
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
	 * @return the availableDate
	 */
	public LocalDate getAvailableDate() {
		return availableDate;
	}

	/**
	 * @param availableDate the availableDate to set
	 */
	public void setAvailableDate(LocalDate availableDate) {
		this.availableDate = availableDate;
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
	public List<AuthorDto> getAuthors() {
		return authors;
	}

	/**
	 * @param authors the authors to set
	 */
	public void setAuthors(List<AuthorDto> authors) {
		this.authors = authors;
	}

	/**
	 * @return the publisher
	 */
	public PublisherDto getPublisher() {
		return publisher;
	}

	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(PublisherDto publisher) {
		this.publisher = publisher;
	}

	/**
	 * @return the genre
	 */
	public GenreDto getGenre() {
		return genre;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(GenreDto genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "BookDateDto [bookId=" + bookId + ", availableDate=" + availableDate + ", bookTitle=" + bookTitle
				+ ", totalPages=" + totalPages + ", publishDate=" + publishDate + ", bookStatus=" + bookStatus
				+ ", bookImageUrl=" + bookImageUrl + ", totalBookCount=" + totalBookCount + ", availableBookCount="
				+ availableBookCount + ", bookRating=" + bookRating + ", authors=" + authors + ", publisher="
				+ publisher + ", genre=" + genre + "]";
	}
	
}
