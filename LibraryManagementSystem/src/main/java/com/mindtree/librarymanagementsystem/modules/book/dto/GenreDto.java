package com.mindtree.librarymanagementsystem.modules.book.dto;


import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class GenreDto {

	@Size(min=1)
	private Long genreId;
	@NotNull
	@Pattern(regexp = "^[a-zA-Z_-]{3,20}$")
	private String genreName;
	@JsonIgnoreProperties({"genre","password"})
	private Set<BookDto> books = new HashSet<>();

	public GenreDto() {
		super();
		
	}

	
	/**
	 * @param genreName
	 */
	public GenreDto(String genreName) {
		super();
		this.genreName = genreName;
	}


	public GenreDto(Long genreId, String genreName, Set<BookDto> books) {
		super();
		this.genreId = genreId;
		this.genreName = genreName;
		this.books = books;
	}

	/**
	 * @return the genreId
	 */
	public Long getGenreId() {
		return genreId;
	}

	/**
	 * @param genreId the genreId to set
	 */
	public void setGenreId(Long genreId) {
		this.genreId = genreId;
	}

	/**
	 * @return the genreName
	 */
	public String getGenreName() {
		return genreName;
	}

	/**
	 * @param genreName the genreName to set
	 */
	public void setGenreName(String genreName) {
		this.genreName = genreName;
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
		return "GenreDto [genreId=" + genreId + ", genreName=" + genreName + ", books=" + books + "]";
	}


}
