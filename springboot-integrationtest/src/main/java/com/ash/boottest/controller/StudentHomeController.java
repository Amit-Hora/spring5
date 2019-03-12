package com.ash.boottest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ash.boottest.model.Student;
import com.ash.boottest.repository.StudentRepository;
import com.google.gson.Gson;

@RestController
public class StudentHomeController {

	 @Autowired
	  private StudentRepository repository;

	@GetMapping("/students/{studentName}")
	public String retrieveCoursesForStudent(@PathVariable String studentName) {
		Gson gson = new Gson();
		
		return gson.toJson(repository.findByName(studentName));
	}
}
