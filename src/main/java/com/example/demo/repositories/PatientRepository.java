package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{

}
