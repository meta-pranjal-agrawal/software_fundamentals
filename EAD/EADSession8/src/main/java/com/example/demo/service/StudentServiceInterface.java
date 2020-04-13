package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentServiceInterface 
{
	public void addStudent(Student student);
	public List<Student> getAllStudents();
	
}
