package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Patient;
import com.example.demo.repositories.PatientRepository;

@RestController
public class PatientController {
	@Autowired
	private PatientRepository patientRepo;
	
	@GetMapping("/patients")
	public List<Patient> getPatients() {
		return patientRepo.findAll();
	}
	@PostMapping("/patients")
	public Patient insertPatient(@RequestBody Patient patient) {
		patientRepo.save(patient);
		return patient;
	}
}
