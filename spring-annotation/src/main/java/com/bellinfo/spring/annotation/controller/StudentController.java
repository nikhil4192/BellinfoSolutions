package com.bellinfo.spring.annotation.controller;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bellinfo.spring.annotation.model.Student;
import com.bellinfo.spring.annotation.repository.StudentRepository;

@Controller
@RequestMapping(value="/student")
public class StudentController {

	 @Autowired
	  StudentRepository repository;
	 
	@RequestMapping(method=RequestMethod.GET)
	public String studentData(Model model){
		Student student = new Student();
		model.addAttribute("student", student);
		model.addAttribute("message", "Welcome....");
		return "student-login";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String postStudentData(@Valid @ModelAttribute("student") Student student, BindingResult result, Model model){
		if(result.hasErrors()){
			return "student-login";
		}
		 String text ="Hey Welcome to MVC world...,"+student.getName();
	        repository.save(student.getName());
	        model.addAttribute("message",text);
	        List<String> list = repository.findAll();
	        model.addAttribute("list",list);
		return "success";
	}
}
