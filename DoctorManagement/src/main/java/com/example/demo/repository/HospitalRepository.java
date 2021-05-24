package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.entity.Hospital;
@Repository
public interface HospitalRepository extends JpaRepository<Hospital,Integer> {
	Optional<Hospital> findByhospitalName(String hospitalName);
}
