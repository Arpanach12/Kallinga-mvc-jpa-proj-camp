package com.mindtree.librarymanagementsystem.modules.book.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.librarymanagementsystem.modules.book.entity.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

	boolean existsByGenreName(String genreName);
	
	Optional<Genre> findByGenreName(String genreName);
	
	
	
	boolean existsBygenreName(String genreName);


	

	
	
	
}
