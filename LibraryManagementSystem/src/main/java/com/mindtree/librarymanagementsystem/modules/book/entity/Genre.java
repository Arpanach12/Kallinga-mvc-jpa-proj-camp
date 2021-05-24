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
@Table(name="genre")
public class Genre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long genreId;
	private String genreName;
	@OneToMany(mappedBy = "genre",cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
	private Set<Book> books=new HashSet<>();
	
	public Genre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Genre(Long genreId, String genreName, Set<Book> books) {
		super();
		this.genreId = genreId;
		this.genreName = genreName;
		this.books = books;
	}

	public Long getGenreId() {
		return genreId;
	}

	public void setGenreId(Long genreId) {
		this.genreId = genreId;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Genre [genreId=" + genreId + ", genreName=" + genreName + ", books=" + books + "]";
	}
	
	
	
	
}
