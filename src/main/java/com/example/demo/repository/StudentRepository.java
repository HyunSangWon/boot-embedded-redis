package com.example.demo.repository;

import com.example.demo.vo.Student;

public interface StudentRepository {

	 void save(Student student);
	 
	 Student find(Long id);
}
