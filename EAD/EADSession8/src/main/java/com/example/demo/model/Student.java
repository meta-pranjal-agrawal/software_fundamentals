package com.example.demo.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Student 
{
	@NotBlank
	String fName;
	@NotBlank
	String lName;
	@NotBlank
	String fatherName;
	@NotBlank
	@Email(message = "{bademail}")
	String email;
	
	@NotNull
	Integer classNumber;
	@NotNull
	Integer age;
	
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	
	public String getlName() 
	{
		return lName;
	}
	
	public void setLName(String lName) {
		this.lName = lName;
	}
	
	public String getfatherName() {
		return fatherName;
	}
	
	public void setfatherName(String fatherName) 
	{
		this.fatherName = fatherName;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getClassNumber() {
		return classNumber;
	}
	public void setClassNumber(Integer classNumber) {
		this.classNumber = classNumber;
	}
	
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	

}
