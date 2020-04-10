package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.Student;

@Service
public class StudentService implements StudentServiceInterface
{
	List<Student> students= new ArrayList<Student>();
	
	@Autowired
	StudentDao studentDao;
	
	/**
	 * adds student to students list
	 */
	@Override
	public void addStudent(Student student) 
	{
		studentDao.addStudent(student);
		
	}
	
	/**
	 * returns list of all students
	 */
	@Override
	public List<Student> getAllStudents() 
	{
		students=studentDao.getAllStudents();
		return students;
	}

}
