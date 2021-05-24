package com.mindtree.classmanagementmvc.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	private String studentName;
	private Date studentdDob;
	private int studentAge;
	private String studentSection;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Class1 class1;

	public Student() {
		super();
	}

	public Student(int studentId, String studentName, Date studentdDob, int studentAge, String studentSection,
			Class1 class1) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentdDob = studentdDob;
		this.studentAge = studentAge;
		this.studentSection = studentSection;
		this.class1 = class1;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Date getStudentdDob() {
		return studentdDob;
	}

	public void setStudentdDob(Date studentdDob) {
		this.studentdDob = studentdDob;
	}

	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}

	public String getStudentSection() {
		return studentSection;
	}

	public void setStudentSection(String studentSection) {
		this.studentSection = studentSection;
	}

	public Class1 getClass1() {
		return class1;
	}

	public void setClass1(Class1 class1) {
		this.class1 = class1;
	}
	
	
}
