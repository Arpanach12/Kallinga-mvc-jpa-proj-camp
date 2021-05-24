package com.mindtree.classmanagementmvc.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Class1 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int classId;
	private String classSection;
	private String teacherName;
	private int noOfStudents;
	
	@OneToMany(mappedBy = "class1", cascade = CascadeType.PERSIST)
	private List<Student> students;

	public Class1() {
		super();
	}

	public Class1(int classId, String classSection, String teacherName, int noOfStudents, List<Student> students) {
		super();
		this.classId = classId;
		this.classSection = classSection;
		this.teacherName = teacherName;
		this.noOfStudents = noOfStudents;
		this.students = students;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassSection() {
		return classSection;
	}

	public void setClassSection(String classSection) {
		this.classSection = classSection;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public int getNoOfStudents() {
		return noOfStudents;
	}

	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
}
