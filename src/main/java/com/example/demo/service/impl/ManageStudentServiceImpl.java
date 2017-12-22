package com.example.demo.service.impl;

import com.example.demo.model.Student;
import com.example.demo.model.StudyProgram;
import com.example.demo.model.exceptions.InvalidIndexValue;
import com.example.demo.model.exceptions.StudentNullPointerException;
import com.example.demo.model.exceptions.StudyProgramNotExisting;
import com.example.demo.persistance.StudentRepository;
import com.example.demo.persistance.StudyProgramRepository;
import com.example.demo.service.ManageStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageStudentServiceImpl implements ManageStudentService {

    StudentRepository studentRepository;
    StudyProgramRepository studyProgramRepository;

    @Autowired
    public ManageStudentServiceImpl(StudentRepository studentRepository, StudyProgramRepository studyProgramRepository){
        this.studentRepository = studentRepository;
        this.studyProgramRepository = studyProgramRepository;
    }

    @Override
    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudent(String index) {
        return studentRepository.findOne(index);
    }

    @Override
    public Iterable<Student> getStudentsByStudyProgram(long id) {
        return studentRepository.findByStudyProgramId(id);
    }




    @Override
    public Student addStudent(String index, String name, String lastName, String studyProgramName) {
        if(index == null || name == null || lastName == null || studyProgramName == null)
            throw new StudentNullPointerException();
        else if(index.length() != 6)
            throw new InvalidIndexValue();
        else if(studyProgramRepository.findByName(studyProgramName) == null)
            throw new StudyProgramNotExisting();

        StudyProgram studyProgram = studyProgramRepository.findByName(studyProgramName);

        Student s = new Student(index, name, lastName, studyProgram);
        return studentRepository.save(s);
    }

    @Override
    public void updateStudent(String index, String newName, String newLastName, String newStudyProgramName) {
        Student student = getStudent(index);
        student.setName(newName);
        student.setLastName(newLastName);

        //new to this study program
        StudyProgram sp = studyProgramRepository.findByName(newStudyProgramName);
        student.setStudyProgram(sp);


        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(String index) {
        studentRepository.delete(index);
    }
}
