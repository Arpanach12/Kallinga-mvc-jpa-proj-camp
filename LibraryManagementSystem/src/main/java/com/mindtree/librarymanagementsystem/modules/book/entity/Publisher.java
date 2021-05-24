package com.mindtree.librarymanagementsystem.modules.book.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="publisher")
public class Publisher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long publisherId;
	private String publisherName;
	@OneToMany(mappedBy = "publisher",cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
	private Set<Book> books=new HashSet<>();
	
	public Publisher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Publisher(Long publisherId, String publisherName, Set<Book> books) {
		super();
		this.publisherId = publisherId;
		this.publisherName = publisherName;
		this.books = books;
	}

	public Long getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(Long publisherId) {
		this.publisherId = publisherId;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Publisher [publisherId=" + publisherId + ", publisherName=" + publisherName + ", books=" + books + "]";
	}
	
	
	
	
}
