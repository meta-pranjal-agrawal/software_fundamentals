package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@Controller
public class StudentController 
{
	
	@Autowired
	StudentService studentService;
	
	/**
	 * 
	 * @param model
	 * @return jsp page of add student
	 */
	@GetMapping("/addstudent")
	public String addStudentaction(Model model)
	{
		model.addAttribute("student",new Student());
		return "addstudent";
	}
	
	/**
	 * 
	 * @param student
	 * @return jsp home page
	 */
	@PostMapping("/addstudent")
	
	public String addStudent(@Validated Student student,BindingResult binding)
	
	
	{
		if (binding.hasErrors()) {
			return "addstudent";
		}
		
		studentService.addStudent(student);
		
		return "home";
		
	}
	
	/**
	 * 
	 * @return list of all students
	 */
	@GetMapping("/showstudents")
	public ModelAndView getAllStudents()
	{
		List<Student> students = studentService.getAllStudents();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("students", students);
		mv.setViewName("showstudents");
		return mv;
	
	}
	

}
