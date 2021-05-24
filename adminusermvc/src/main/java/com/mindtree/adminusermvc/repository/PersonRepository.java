package com.mindtree.adminusermvc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.adminusermvc.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

	Optional<Person> findBypersonName(String personName);

}
