package com.example.demo.web;


import com.example.demo.model.Student;
import com.example.demo.model.exceptions.InvalidIndexValue;
import com.example.demo.model.exceptions.StudentNullPointerException;
import com.example.demo.model.exceptions.StudyProgramNotExisting;
import com.example.demo.service.ManageStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/students", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class ManageStudentsController {

    private ManageStudentService studentService;

    @Autowired
    public ManageStudentsController(ManageStudentService studentService){
        this.studentService = studentService;
    }

    //OK
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Student> getStudents(){
        return studentService.getAllStudents();
    }

    //OK
    @RequestMapping(value = "{index}", method = RequestMethod.GET)
    public Student getStudent(@PathVariable String index){
        return studentService.getStudent(index);
    }

    //OK
    @RequestMapping(value = "by_study_program/{id}", method = RequestMethod.GET)
    public Iterable<Student> getStudentsByStudyProgram(@PathVariable long id){
        return studentService.getStudentsByStudyProgram(id);
    }

    //NE MOZE OVAKA DA SE IZVEDE. POTVRDI!!
    /*@RequestMapping(method = RequestMethod.POST)
    public Student createStudent(@RequestBody String index, @RequestBody String name,
                                 @RequestBody String lastName, @RequestBody String studyProgramName){
        return studentService.addStudent(index, name, lastName, studyProgramName);
    }*/

    //OK
    /*
    @RequestMapping(method = RequestMethod.POST)
    public void createStudent(HttpServletRequest req, HttpServletResponse resp){
        String index = req.getParameter("index");
        String name = req.getParameter("name");
        String lastName = req.getParameter("lastName");
        String studyProgramName = req.getParameter("studyProgramName");

        System.out.println("ISPISI: " + name + ", " + lastName + ", " + studyProgramName);

        studentService.addStudent(index, name, lastName, studyProgramName);
        resp.setStatus(HttpServletResponse.SC_CREATED);
        resp.setHeader("Location", "http://localhost:8080/api/students/" + index);
    }*/

    @RequestMapping(method = RequestMethod.POST)
    public Optional<Student> createStudent(@RequestBody Student student, HttpServletResponse resp){
        System.out.println("ISPISI: " + student.getName() + ", " + student.getLastName() + ", " + student.getStudyProgram().getName());

        studentService.addStudent(student.getIndeks(), student.getName(), student.getLastName(), student.getStudyProgram().getName());
        resp.setStatus(HttpServletResponse.SC_CREATED);
        resp.setHeader("Location", "http://localhost:8080/api/students/" + student.getIndeks());
        return Optional.of(student);
    }

    /* NE MOZE SO @RequestParam zatoa sto prenesuvam vo body-to simple params.
    @RequestMapping(value = "{index}", method = RequestMethod.PATCH)
    public void updateStudent(@PathVariable String index, @RequestParam String name,
                              @RequestParam String lastName, @RequestParam String studyProgramName,
                              HttpServletResponse resp) {
        studentService.updateStudent(index, name, lastName, studyProgramName);
    }*/

    //OK
    /*
    @RequestMapping(value = "{index}", method = RequestMethod.PATCH)
    public void updateStudent(@PathVariable String index, @RequestParam String name, @RequestParam String lastName, @RequestParam String studyProgramName) {
        System.out.println("ISPISI: " + name + ", " + lastName + ", " + studyProgramName);

        studentService.updateStudent(index, name, lastName, studyProgramName);
    }
    */


    @RequestMapping(value = "{index}", method = RequestMethod.PATCH)
    public Optional<Student> updateStudent(@PathVariable String index, @RequestBody Student student) {
        //System.out.println("ISPISI: " + student.name + ", " + lastName + ", " + studyProgramName);
        System.out.println("===UPDATE===");

        studentService.updateStudent(index, student.getName(), student.getLastName(), student.getStudyProgram().getName());
        return Optional.of(student);
    }

    //OK
    @RequestMapping(value = "{index}", method = RequestMethod.DELETE)
    public String removeStudent(@PathVariable String index) {
        studentService.deleteStudent(index);
        return index;
    }



}
