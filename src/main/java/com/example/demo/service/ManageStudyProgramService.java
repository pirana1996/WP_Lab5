package com.example.demo.service;

import com.example.demo.model.StudyProgram;

public interface ManageStudyProgramService {
    public Iterable<StudyProgram> getAllStudyPrograms();

    public StudyProgram addStudyProgram(String name);

    public void deleteStudyProgram(long name);
}
