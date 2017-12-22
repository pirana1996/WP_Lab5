package com.example.demo.persistance;

import com.example.demo.model.Student;
import com.example.demo.model.StudyProgram;

public interface StudyProgramRepository {
    public Iterable<StudyProgram> findAll();

    public StudyProgram save(StudyProgram studyProgram);

    //WARNING
    //public Student findStudentsByName(String studyProgramName);

    public StudyProgram findByName(String studyProgramName);

    public void delete(long id);
}
