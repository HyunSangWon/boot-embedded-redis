package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.StudentService;
import com.example.demo.vo.Student;

@RestController
@RequestMapping("/redis")
public class RedisController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping
	public String saveStudentInformation(@RequestBody Student student) {
		studentService.save(student);
		return "success";
	}
	
	@GetMapping(path = "{id}")
	public Student fetchStudent(@PathVariable("id") long id) {
		return studentService.find(id);
	}
}