package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int doctorId;
	private String doctorName;
	private String specialist;
	private int doctorSalary;
	@ManyToMany(cascade = CascadeType.PERSIST)
	List<Hospital> hospitalList;
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getSpecialist() {
		return specialist;
	}
	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}
	public int getDoctorSalary() {
		return doctorSalary;
	}
	public void setDoctorSalary(int doctorSalary) {
		this.doctorSalary = doctorSalary;
	}
	public List<Hospital> getHospitalList() {
		return hospitalList;
	}
	public void setHospitalList(List<Hospital> hospitalList) {
		this.hospitalList = hospitalList;
	}
	public Doctor(int doctorId, String doctorName, String specialist, int doctorSalary, List<Hospital> hospitalList) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.specialist = specialist;
		this.doctorSalary = doctorSalary;
		this.hospitalList = hospitalList;
	}
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}