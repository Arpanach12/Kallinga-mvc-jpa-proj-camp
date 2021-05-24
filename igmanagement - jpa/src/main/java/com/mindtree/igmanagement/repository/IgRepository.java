package com.mindtree.igmanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.igmanagement.entity.Ig;

@Repository
public interface IgRepository extends JpaRepository<Ig, Integer> {

	Optional<Ig> findByigName(String igName);

}
