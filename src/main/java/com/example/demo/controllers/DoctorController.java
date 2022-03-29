package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Doctor;
import com.example.demo.repositories.DoctorRepository;

@RestController
public class DoctorController {
	@Autowired
	private DoctorRepository doctorRepo;
	
	@GetMapping("/doctors")
	public List<Doctor> getDoctors(){
		return doctorRepo.findAll();
	}
	@PostMapping("/doctors")
	public Doctor insertDoctor(@RequestBody Doctor doctor) {
		doctorRepo.save(doctor);
		return doctor;
	}
}
