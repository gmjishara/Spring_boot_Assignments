package edu.icet.assignment01.controller;

import edu.icet.assignment01.dao.StudentEntity;
import edu.icet.assignment01.dto.Student;
import edu.icet.assignment01.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

    @Autowired
    StudentService service;

    @GetMapping
    public Iterable<StudentEntity> getStudent(){
        return service.getAllStudent();
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        return service.createStudent(student);
    }

}
