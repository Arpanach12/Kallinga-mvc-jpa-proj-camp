package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.Hospital;

public interface DoctorService {

	/**
	 * @param doctor
	 */
	void insertingDoctor(Doctor doctor);

	List<Doctor> getDoctor();

	List<Doctor> getDoctors(Hospital hospital);

	void deletingDoctor(String hospitalName, String doctorName);

	

}
