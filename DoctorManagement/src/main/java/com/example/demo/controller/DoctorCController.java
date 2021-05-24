package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.Hospital;
import com.example.demo.service.DoctorService;
import com.example.demo.service.HospitalService;

@Controller
public class DoctorCController {
	
	@Autowired
	DoctorService doctorservice;
	
	@Autowired
	HospitalService hospitalservice;
	
	@RequestMapping("/")
	public String link1() {
		return "home";
	}

	@RequestMapping("/addhospital")
	public String link3() {
		return "addhospital";
	}
	
	@PostMapping("/inserthospital")
	public String inserthospitals(Hospital hospital) {
		hospitalservice.insertingHospital(hospital);
		return "home";
	}	
	
	@RequestMapping("/adddoctor")
	public String link2() {
		return "adddoctor";
	}
	@PostMapping("/insertdoctor")
	public String insertdoctors(Doctor doctor) {
		doctorservice.insertingDoctor(doctor);
		return "home";
	}
	@RequestMapping("/assign")
	public String link3(Model model) {
		List<Hospital> hospital=hospitalservice.getHospital();
		List<Doctor> doctor=doctorservice.getDoctor();
		model.addAttribute("hospitalslist", hospital);
		model.addAttribute("doctorslist", doctor);
		return "assign";
	}
	
	@PostMapping("/setuserandhospital")
	public String insertdocandhospital(Hospital hospital1) {
		hospitalservice.insertdocandhospitals(hospital1);
		return "home";
	}
	
	@RequestMapping("/display")
	public String link2(Model model) {
		List<Hospital> hospital=hospitalservice.getHospitals();
		model.addAttribute("hospitalslist",hospital);
		return "display";
	}
	@RequestMapping("/getdoctors")
	public String link8(Hospital hospital,Model model) {
		List<Doctor> doctor=doctorservice.getDoctors(hospital);
		model.addAttribute("doctorslists1",doctor);
		return "display";
	}
	
	@RequestMapping("/delete")
	public String link9() {
		return "delete";
	}
	
	
	@RequestMapping("/deletedoctor")
	public String deleteDoctor(String hospitalName,String doctorName) {
		doctorservice.deletingDoctor(hospitalName,doctorName);
		return "home";
	}
	
}
