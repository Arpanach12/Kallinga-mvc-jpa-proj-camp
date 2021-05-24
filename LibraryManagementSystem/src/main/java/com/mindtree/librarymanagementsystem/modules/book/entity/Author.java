package com.mindtree.librarymanagementsystem.modules.book.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "author")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long authorId;
	private String authorName;
	@ManyToMany
	private List<Book> books =new ArrayList<Book>(); 

	/**
	 * @param authorId
	 * @param authorName
	 * @param books
	 */
	public Author(Long authorId, String authorName, List<Book> books) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
		this.books = books;
	}

	/**
	 * 
	 */
	public Author() {
		super();
		
	}

	/**
	 * @return Long
	 */
	public Long getAuthorId() {
		return authorId;
	}

	/**
	 * @param authorId
	 */
	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	/**
	 * @return
	 */
	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", authorName=" + authorName + ", books=" + books + "]";
	};

}
