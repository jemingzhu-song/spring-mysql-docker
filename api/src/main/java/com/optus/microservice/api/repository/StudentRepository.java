package com.optus.microservice.api.repository;

import com.optus.microservice.api.models.Student;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{

}