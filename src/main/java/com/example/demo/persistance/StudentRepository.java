package com.example.demo.persistance;

import com.example.demo.model.Student;

public interface StudentRepository {
    Iterable<Student> findAll();

    Student findOne(String index);

    Iterable<Student> findByStudyProgramId(long id);

    Student save(Student s);

    void delete(String index);

}
