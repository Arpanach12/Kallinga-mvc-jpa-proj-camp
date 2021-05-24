package com.mindtree.classmanagementmvc.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.classmanagementmvc.entity.Class1;
import com.mindtree.classmanagementmvc.entity.Student;
import com.mindtree.classmanagementmvc.exception.serviceexception.ClassManagementServiceException;
import com.mindtree.classmanagementmvc.exception.serviceexception.NumberOfStudentsExceedClassStrength;
import com.mindtree.classmanagementmvc.repository.ClassRepository;
import com.mindtree.classmanagementmvc.repository.StudentRepository;
import com.mindtree.classmanagementmvc.service.ClassManagementService;

@Service
public class ClassManagementServiceImpl implements ClassManagementService {

	
	@Autowired
	private ClassRepository classRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public void insertClassToDB(Class1 class1) {
	
		classRepository.save(class1);
	}

	@Override
	public void insertStudentToDB(int classId, Student student) throws ClassManagementServiceException {

		Class1 class1 = classRepository.getOne(classId);
		student.setStudentSection(class1.getClassSection());
		List<Student> students = studentRepository.findBystudentSection(class1.getClassSection());
		
		if(students.size()>=class1.getNoOfStudents())
		{
			try {
			throw new NumberOfStudentsExceedClassStrength("No of students exceeds class Strength");
		}catch(NumberOfStudentsExceedClassStrength e) {
			throw new ClassManagementServiceException(e.getMessage(), e);
		}
		}
		
		student.setClass1(class1);
		studentRepository.save(student);
	}

	@Override
	public List<Class1> getSections() {
		
		return classRepository.findAll();
		
	}

	@Override
	public List<Student> getStudentsBasedOnSection(int classId) {
		
		Class1 class1 = classRepository.getOne(classId);
		return class1.getStudents();
	}

}
