package com.example.demo.web;

import com.example.demo.model.StudyProgram;
import com.example.demo.service.ManageStudyProgramService;
import com.example.demo.service.impl.ManageStudyProgramServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "api/study_programs", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class ManageStudyProgramController {

    private ManageStudyProgramService studyProgramService;

    @Autowired
    public ManageStudyProgramController(ManageStudyProgramService studyProgramService){
        this.studyProgramService = studyProgramService;
    }

    //OK
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<StudyProgram> getAllStudyPrograms(){
        return studyProgramService.getAllStudyPrograms();
    }

    //OK
    @RequestMapping(method = RequestMethod.POST)
    public StudyProgram createStudyProgram(HttpServletRequest req){
            String name = req.getParameter("name");
        return studyProgramService.addStudyProgram(name);
    }

    //OK
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public String deleteStudyProgram(@PathVariable long id){
        studyProgramService.deleteStudyProgram(id);
        return String.valueOf(id);
    }
}
