package com.example.demo.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastname;
	@Column(unique = true)
	private String username;
	private String password;
	private Integer age;
	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	private Date registrationTime;
	@ManyToMany(mappedBy = "doctors")
	private Set<Patient> patients = new HashSet<>();
	
	public Doctor() {
	}
	
	public Doctor(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Doctor(Long id, String firstName, String lastname, String username, String password, Integer age,
			Date registrationTime, Set<Patient> patients) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.age = age;
		this.registrationTime = registrationTime;
		this.patients = patients;
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
	public String toString() {
		return "Doctor [id=" + id + ", firstName=" + firstName + ", lastname=" + lastname + ", username=" + username
				+ ", password=" + password + ", age=" + age + ", registrationTime=" + registrationTime + ", patients="
				+ patients + "]";
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
	
}
