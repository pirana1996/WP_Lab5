package com.example.demo.service;

import com.example.demo.model.Student;

public interface ManageStudentService {
    Iterable<Student> getAllStudents();

    Student getStudent(String index);

    Iterable<Student> getStudentsByStudyProgram(long id);

    Student addStudent(String index, String name, String lastName, String studyProgramName);

    void updateStudent(String index, String newName, String newLastName, String newStudyProgramName);

    void deleteStudent(String index);
}
