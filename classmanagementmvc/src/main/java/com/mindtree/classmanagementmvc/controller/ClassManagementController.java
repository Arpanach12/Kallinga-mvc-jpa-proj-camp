package com.mindtree.classmanagementmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mindtree.classmanagementmvc.entity.Class1;
import com.mindtree.classmanagementmvc.entity.Student;
import com.mindtree.classmanagementmvc.exception.controllerexception.ClassManagementControllerException;
import com.mindtree.classmanagementmvc.exception.serviceexception.ClassManagementServiceException;
import com.mindtree.classmanagementmvc.service.ClassManagementService;

@Controller
public class ClassManagementController {

	@Autowired
	private ClassManagementService service;
	
	@GetMapping("/")
	public String homePage() {
		
		return "index";
	}
	
	@GetMapping("/class")
	public String registerClass() {
		
		return "registerclass";
	}
	
	@PostMapping("/insertclass")
	public String insertClass(Class1 class1) {
		
		service.insertClassToDB(class1);
		return "registerclass";
	}
	
	@GetMapping("/student")
	public String registerStudent(Model model) {
		
		List<Class1> classes = service.getSections();
		model.addAttribute("classes",classes);
		return "registerstudent";
	}
	
	@PostMapping("/insertstudent")
	public String insertStudent(@RequestParam int classId, Student student,Model model) throws ClassManagementControllerException {
		
		try {
			service.insertStudentToDB(classId,student);
		} catch (ClassManagementServiceException e) {
			throw new ClassManagementControllerException(e.getMessage(), e);
		}
		
		List<Class1> classes = service.getSections();
		model.addAttribute("classes",classes);
		return "registerstudent";
	}
	
	@GetMapping("/display")
	public String displayStudents(Model model) {
		
		List<Class1> classes = service.getSections();
		model.addAttribute("classes",classes);
		return "displaystudents";
	}
	
	@PostMapping("/showstudents")
	public String showStudents(@RequestParam int classId,Model model) {
		
		List<Student> students = service.getStudentsBasedOnSection(classId);
		model.addAttribute("students", students);
		List<Class1> classes = service.getSections();
		model.addAttribute("classes",classes);
		return "displaystudents";
	}
}
