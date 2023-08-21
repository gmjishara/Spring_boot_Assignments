package edu.icet.assignment01.controller;

import edu.icet.assignment01.dto.Student;
import edu.icet.assignment01.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class StudentController {

    @Autowired
    StudentService service;

    @PostMapping("/student")
    public void createStudent(@RequestBody Student student){
        service.createStudent(student);
    }
}
