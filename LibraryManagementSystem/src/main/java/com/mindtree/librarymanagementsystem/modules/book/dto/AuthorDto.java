package com.mindtree.librarymanagementsystem.modules.book.dto;


import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

public class AuthorDto {

	
	private Long authorId;
	
	@NotNull
	@Pattern(regexp = "^[a-zA-Z_-]{3,50}$")
	private String authorName;
	@JsonIgnoreProperties({"authors","password"})
	private List<BookDto> books = new ArrayList<>();

	public AuthorDto(Long authorId, String authorName, List<BookDto> books) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
		this.books = books;
	}

	
	/**
	 * @param authorName
	 */
	public AuthorDto(String authorName) {
		super();
		this.authorName = authorName;
	}


	public AuthorDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the authorId
	 */
	public Long getAuthorId() {
		return authorId;
	}

	/**
	 * @param authorId the authorId to set
	 */
	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	/**
	 * @return the authorName
	 */
	public String getAuthorName() {
		return authorName;
	}

	/**
	 * @param authorName the authorName to set
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	/**
	 * @return the books
	 */
	public List<BookDto> getBooks() {
		return books;
	}

	/**
	 * @param books the books to set
	 */
	public void setBooks(List<BookDto> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "AuthorDto [authorId=" + authorId + ", authorName=" + authorName + ", books=" + books + "]";
	}


}
