package com.optus.microservice.api.controllers;

import com.optus.microservice.api.models.Student;
import com.optus.microservice.api.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
  
  @Autowired
	StudentRepository studentRepository;

  @PostMapping("/student")
  public void createStudent(@RequestBody Student s) {
    studentRepository.save(s);
  }

  @GetMapping("/students")
  public Iterable<Student> getStudents() {
    return studentRepository.findAll();
  }

}
