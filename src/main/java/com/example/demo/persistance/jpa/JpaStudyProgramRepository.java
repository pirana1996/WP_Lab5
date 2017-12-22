package com.example.demo.persistance.jpa;

import com.example.demo.model.StudyProgram;
import com.example.demo.persistance.StudyProgramRepository;
import org.springframework.data.repository.Repository;

public interface JpaStudyProgramRepository extends StudyProgramRepository, Repository<StudyProgram, Long> {
}
