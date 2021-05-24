package com.mindtree.classmanagementmvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.classmanagementmvc.entity.Class1;
import com.mindtree.classmanagementmvc.entity.Student;
import com.mindtree.classmanagementmvc.exception.serviceexception.ClassManagementServiceException;

@Service
public interface ClassManagementService {

	void insertClassToDB(Class1 class1);

	void insertStudentToDB(int classId, Student student) throws ClassManagementServiceException;

	List<Class1> getSections();

	List<Student> getStudentsBasedOnSection(int classId);

}
