package com.example.demo.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    private String indeks; //(primary key)
    private String name;
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "study_program_id")
    StudyProgram studyProgram; //(foreign key)

    public Student(){}

    public Student(String index, String name, String lastName, StudyProgram studyProgram){
        this.indeks = index;
        this.name = name;
        this.lastName = lastName;
        this.studyProgram = studyProgram;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStudyProgram(StudyProgram studyProgram) {
        this.studyProgram = studyProgram;
    }

    public String getIndeks() {
        return indeks;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public StudyProgram getStudyProgram() {
        return studyProgram;
    }
}
