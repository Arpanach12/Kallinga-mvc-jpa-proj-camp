package com.mindtree.classmanagementmvc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.classmanagementmvc.entity.Class1;

@Repository
public interface ClassRepository extends JpaRepository<Class1, Integer> {

	Class1 findByclassSection(String classSection);

}
