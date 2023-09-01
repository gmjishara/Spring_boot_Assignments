package edu.icet.assignment01.controller;

import edu.icet.assignment01.dao.StudentEntity;
import edu.icet.assignment01.dto.Student;
import edu.icet.assignment01.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

    //spring assign a suitable object in runtime
    @Autowired
    StudentService service;

    //view student
    @GetMapping
    public Iterable<StudentEntity> getStudent(){
        return service.getAllStudent();
    }

    //create student
    @PostMapping
    public ResponseEntity<StudentEntity> createStudent(@ModelAttribute Student student) throws IOException {
        return service.createStudent(student);
    }

}
