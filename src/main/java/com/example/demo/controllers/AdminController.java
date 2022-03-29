package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Admin;
import com.example.demo.repositories.AdminRepository;

@RestController
public class AdminController {
	@Autowired
	private AdminRepository adminRepo;
	
	@GetMapping("/admins")
	public List<Admin> getAdmins(){
		return adminRepo.findAll();
	}
	
	@PostMapping("/admins")
	public Admin insertAdmin(@RequestBody Admin admin) {
		adminRepo.save(admin);
		return admin;
	}
}
