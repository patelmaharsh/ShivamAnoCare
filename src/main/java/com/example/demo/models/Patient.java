package com.example.demo.models;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	@Column(unique = true)
	private String username;
	private String password;
	private Integer age;
	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	private Date registrationTime;
	@ManyToMany
	@JoinTable(name = "doctor_patient", joinColumns = @JoinColumn(name = "patient_id"), inverseJoinColumns = @JoinColumn(name="doctor_id"))
	private Set<Doctor> doctors;
	public Patient() {
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
	
	public Patient(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public Patient(Long id, String firstName, String lastName, String username, String password, Integer age,
			Date registrationTime, Set<Doctor> doctors) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.age = age;
		this.registrationTime = registrationTime;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getRegistrationTime() {
		return registrationTime;
	}

	public void setRegistrationTime(Date registrationTime) {
		this.registrationTime = registrationTime;
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
		return "Patient [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + ", age=" + age + ", registrationTime=" + registrationTime + ", doctors="
				+ doctors + "]";
	}
	
	
	
}
