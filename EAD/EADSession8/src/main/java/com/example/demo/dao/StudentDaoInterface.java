package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentDaoInterface 
{
	public List<Student> getAllStudents();
	
	public void addStudent(Student student);

}
