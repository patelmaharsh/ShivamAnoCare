package com.example.demo.models;

import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	@ManyToMany
	@JoinTable(name = "doctor_patient", joinColumns = @JoinColumn(name = "patient_id"), inverseJoinColumns = @JoinColumn(name="doctor_id"))
	private Set<Doctor> doctors;
	public Patient() {
	}
	public Patient(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Patient(String firstName, String lastName, Set<Doctor> doctors) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.doctors = doctors;
	}
	
	public Patient(Long id, String firstName, String lastName, Set<Doctor> doctors) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.doctors = doctors;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Set<Doctor> getDoctors() {
		return doctors;
	}
	public void setDoctors(Set<Doctor> doctors) {
		this.doctors = doctors;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "Patient [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", doctors=" + doctors
				+ "]";
	}
	
}
