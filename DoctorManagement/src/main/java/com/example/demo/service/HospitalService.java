package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Hospital;

public interface HospitalService {

	void insertingHospital(Hospital hospital);

	List<Hospital> getHospital();

	void insertdocandhospitals(Hospital hospital1);

	List<Hospital> getHospitals();

}
