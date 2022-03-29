package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{

}
