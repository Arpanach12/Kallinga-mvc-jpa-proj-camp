package com.example.demo.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.Hospital;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.HospitalRepository;
import com.example.demo.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {
	@Autowired
	DoctorRepository doctorrepository;

	@Autowired
	HospitalRepository hospitalrepository;

	@Override
	public void insertingDoctor(Doctor doctor) {

		doctorrepository.save(doctor);

	}

	@Override
	public List<Doctor> getDoctor() {

		return doctorrepository.findAll();
	}

	@Override
	public List<Doctor> getDoctors(Hospital hospital) {
		List<Hospital> hospi = hospitalrepository.findAll();
		List<Doctor> doctorslists1 = new ArrayList<Doctor>();
		for (Hospital hospital1 : hospi) {
			if (hospital1.getHospitalName().equals(hospital.getHospitalName()))
				doctorslists1 = hospital1.getDoctorList();
		}
		return doctorslists1;
	}

	@Override
	public void deletingDoctor(String hospitalName, String doctorName) {
		Optional<Doctor> opDoc = doctorrepository.findBydoctorName(doctorName);
		if (!opDoc.isPresent()) {
			System.out.println("doctor is not there");
		}
		Doctor doctor = opDoc.get();
		Optional<Hospital> opHos = hospitalrepository.findByhospitalName(hospitalName);
		if (!opHos.isPresent()) {
			System.out.println("hospital is not there");
		}
		Hospital hospital = opHos.get();
//		for (int i = 0; i < hospital.getDoctorList().size(); i++) {
//			if (hospital.getDoctorList().get(i).getDoctorId() == doctor.getDoctorId()) {
//				
//				hospital.getDoctorList().set(i, null);
//			}
//		}
		for (int i = 0; i < doctor.getHospitalList().size(); i++) {
			if (doctor.getHospitalList().get(i).getHospitalId() == hospital.getHospitalId()) {
				
				doctor.getHospitalList().set(i, null);
			}
		}
		//hospitalrepository.saveAndFlush(hospital);
		doctorrepository.save(doctor);
	}

}
