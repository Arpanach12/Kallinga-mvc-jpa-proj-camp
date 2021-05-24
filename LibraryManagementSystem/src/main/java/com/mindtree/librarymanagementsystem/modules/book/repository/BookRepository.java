package com.mindtree.librarymanagementsystem.modules.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.librarymanagementsystem.modules.book.entity.Book;

@Repository



public interface BookRepository extends JpaRepository<Book, Long> {
	
	
	boolean existsBybookTitle(String bookTitle);



}
