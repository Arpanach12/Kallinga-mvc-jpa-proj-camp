package com.mindtree.librarymanagementsystem.modules.book.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.librarymanagementsystem.modules.book.entity.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {

	boolean existsByPublisherName(String publisherName);

	Optional<Publisher> findByPublisherName(String publisherName);

	boolean existsBypublisherName(String publisherName);

}
