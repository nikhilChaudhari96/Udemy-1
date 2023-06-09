package com.example.demo.model;

import java.time.LocalDate;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class User {
private Integer id;
@Size(min=5)
private String name;
@Past
private LocalDate dateOfBirth;
public User(int id, String name, LocalDate dateOfBirth) {
	super();
	this.id = id;
	this.name = name;
	this.dateOfBirth = dateOfBirth;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public LocalDate getDateOfBirth() {
	return dateOfBirth;
}
public void setDateOfBirth(LocalDate dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}
@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + "]";
}

}
