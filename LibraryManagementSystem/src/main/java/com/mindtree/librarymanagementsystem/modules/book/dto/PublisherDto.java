package com.mindtree.librarymanagementsystem.modules.book.dto;

import java.util.HashSet;
import java.util.Set;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class PublisherDto {

	@Size(min=1)
	private Long publisherId;
	@NotBlank
	@Pattern(regexp = "^[a-zA-Z_-]{3,30}$")
	private String publisherName;
	@JsonIgnoreProperties({"publisher","password"})
	private Set<BookDto> books = new HashSet<>();


	public PublisherDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	/**
	 * @param publisherName
	 */
	public PublisherDto(String publisherName) {
		super();
		this.publisherName = publisherName;
	}



	public PublisherDto(Long publisherId, String publisherName, Set<BookDto> books) {
		super();
		this.publisherId = publisherId;
		this.publisherName = publisherName;
		this.books = books;
	}

	/**
	 * @return the publisherId
	 */
	public Long getPublisherId() {
		return publisherId;
	}

	/**
	 * @param publisherId the publisherId to set
	 */
	public void setPublisherId(Long publisherId) {
		this.publisherId = publisherId;
	}

	/**
	 * @return the publisherName
	 */
	public String getPublisherName() {
		return publisherName;
	}

	/**
	 * @param publisherName the publisherName to set
	 */
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	/**
	 * @return the books
	 */
	public Set<BookDto> getBooks() {
		return books;
	}

	/**
	 * @param books the books to set
	 */
	public void setBooks(Set<BookDto> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "PublisherDto [publisherId=" + publisherId + ", publisherName=" + publisherName + ", books=" + books
				+ "]";
	}

}
