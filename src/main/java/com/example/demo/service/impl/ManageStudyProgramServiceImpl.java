package com.example.demo.service.impl;

import com.example.demo.model.Student;
import com.example.demo.model.StudyProgram;
import com.example.demo.persistance.StudentRepository;
import com.example.demo.persistance.StudyProgramRepository;
import com.example.demo.service.ManageStudyProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageStudyProgramServiceImpl implements ManageStudyProgramService {

    private StudentRepository studentRepository;
    private StudyProgramRepository studyProgramRepository;

    @Autowired
    public ManageStudyProgramServiceImpl(StudyProgramRepository studyProgramRepository, StudentRepository studentRepository){
        this.studyProgramRepository = studyProgramRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public Iterable<StudyProgram> getAllStudyPrograms() {
        return studyProgramRepository.findAll();
    }

    @Override
    public StudyProgram addStudyProgram(String name) {
        StudyProgram studyProgram = new StudyProgram(name);
        return studyProgramRepository.save(studyProgram);
    }

    @Override
    public void deleteStudyProgram(long id) {
        Iterable<Student> students = studentRepository.findByStudyProgramId(id);
        for(Student student: students)
            studentRepository.delete(student.getIndeks());
        studyProgramRepository.delete(id);
    }
}
