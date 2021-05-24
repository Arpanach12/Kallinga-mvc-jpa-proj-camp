package com.example.demo.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Doctor;

import com.example.demo.entity.Hospital;

import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.HospitalRepository;
import com.example.demo.service.HospitalService;

@Service
public class HospitalServiceImpl implements HospitalService {
	@Autowired
	DoctorRepository doctorrepository;

	@Autowired
	HospitalRepository hospitalrepository;

	@Override
	public void insertingHospital(Hospital hospital) {
		hospitalrepository.save(hospital);

	}

	@Override
	public List<Hospital> getHospital() {

		return hospitalrepository.findAll();
	}

	@Override
	public void insertdocandhospitals(Hospital hospital1) {

		List<Hospital> hospi = hospitalrepository.findAll();
		for (Hospital hospital : hospi) {
			if (hospital.getHospitalName().equals(hospital1.getHospitalName()))
				hospital1.setHospitalId(hospital.getHospitalId());
			hospital1.setHospitalLocation(hospital.getHospitalLocation());
		}
		List<Doctor> doctorslists = hospital1.getDoctorList();
		List<Hospital> hospitalslists = new ArrayList<Hospital>();
		hospitalslists.add(hospital1);
		for (Doctor doctor : doctorslists) {
			doctor.setHospitalList(hospitalslists);
		}
		hospital1.setDoctorList(doctorslists);
		hospitalrepository.saveAndFlush(hospital1);
	}

	@Override
	public List<Hospital> getHospitals() {
		List<Hospital> hospital1 = hospitalrepository.findAll();
		return hospital1;
	}

}
