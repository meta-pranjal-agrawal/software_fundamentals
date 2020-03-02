package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository
public class StudentDao implements StudentDaoInterface
{
	List<Student> students= new ArrayList<Student>();
	
	/**
	 * returns all students
	 */
	@Override
	public List<Student> getAllStudents() 
	{
		return students;
	}
	
	/**
	 * adds student to list of student
	 */
	@Override
	public void addStudent(Student student) 
	{
		
		students.add(student);
		
	}

}
