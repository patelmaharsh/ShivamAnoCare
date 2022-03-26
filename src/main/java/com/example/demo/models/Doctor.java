package com.example.demo.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastname;
	@ManyToMany(mappedBy = "doctors")
	private Set<Patient> patients = new HashSet<>();
	
	public Doctor() {
	}
	public Doctor(String firstName, String lastname) {
		this.firstName = firstName;
		this.lastname = lastname;
	}
	public Doctor(String firstName, String lastname, Set<Patient> patients) {
		this.firstName = firstName;
		this.lastname = lastname;
		this.patients = patients;
	}
	
	public Doctor(Long id, String firstName, String lastname, Set<Patient> patients) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastname = lastname;
		this.patients = patients;
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
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Set<Patient> getPatients() {
		return patients;
	}
	public void setPatients(Set<Patient> patients) {
		this.patients = patients;
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
		Doctor other = (Doctor) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", firstName=" + firstName + ", lastname=" + lastname + ", patients=" + patients
				+ "]";
	}
}
