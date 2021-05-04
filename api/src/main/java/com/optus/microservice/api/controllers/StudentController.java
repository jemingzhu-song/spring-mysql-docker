package com.optus.microservice.api.controllers;

import java.util.Optional;

import com.optus.microservice.api.models.Student;
import com.optus.microservice.api.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
  
  @Autowired
	StudentRepository studentRepository;

  @PostMapping("/student")
  public String createStudent(@RequestBody Student s) {
    studentRepository.save(s);
    return "Successfully created student " + s.getName();
  }

  @GetMapping("/students")
  public Iterable<Student> getStudents() {
    return studentRepository.findAll();
  }

  @PutMapping("/student/{id}")
  public String updateStudent(@RequestBody Student s, @PathVariable Long id) {
    Optional<Student> optDBStudent = studentRepository.findById(id);
    if (!optDBStudent.isPresent()) {
      return "Unable to find a student with the specified ID";
    }
    
    Student dbStudent = optDBStudent.get();
    dbStudent.setName(s.getName());
    studentRepository.save(dbStudent);
    return "Successfully updated student";
  }

  @DeleteMapping("/student/{id}")
  public String deleteStudent(@PathVariable Long id) {
    studentRepository.deleteById(id);
    return "Successfully deleted student";
  }

}
