package com.example.demo.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.StudentService;

@Controller
public class HomeController
{
	@Autowired
	StudentService studentService;
	
	@Value("${home.message}")
	private String message;
	
	/**
	 * 
	 * @return jsp home page
	 */
	@GetMapping({"/","/home"})
	public String showHomePage(Model model)
	{
		model.addAttribute("msg",message);
		return "home";
	}
	
	
}
