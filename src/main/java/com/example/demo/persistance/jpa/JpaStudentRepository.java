package com.example.demo.persistance.jpa;

import com.example.demo.model.Student;
import com.example.demo.persistance.StudentRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.Repository;

public interface JpaStudentRepository extends StudentRepository, Repository<Student, String> {
}


