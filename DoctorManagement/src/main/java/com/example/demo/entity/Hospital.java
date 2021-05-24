package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int hospitalId;
	private String hospitalName;
	private String hospitalLocation;
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "hospitalList")
	private List<Doctor> doctorList;
	public int getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getHospitalLocation() {
		return hospitalLocation;
	}
	public void setHospitalLocation(String hospitalLocation) {
		this.hospitalLocation = hospitalLocation;
	}
	public List<Doctor> getDoctorList() {
		return doctorList;
	}
	public void setDoctorList(List<Doctor> doctorList) {
		this.doctorList = doctorList;
	}
	public Hospital(int hospitalId, String hospitalName, String hospitalLocation, List<Doctor> doctorList) {
		super();
		this.hospitalId = hospitalId;
		this.hospitalName = hospitalName;
		this.hospitalLocation = hospitalLocation;
		this.doctorList = doctorList;
	}
	public Hospital() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
