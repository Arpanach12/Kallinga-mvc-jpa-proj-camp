package com.mindtree.librarymanagementsystem.modules.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.librarymanagementsystem.modules.book.entity.Author;
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

	boolean existsByAuthorName(String authorName);

	Author findByAuthorName(String authorName);
	
}
