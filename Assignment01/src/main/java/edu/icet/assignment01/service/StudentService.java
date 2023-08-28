package edu.icet.assignment01.service;

import edu.icet.assignment01.dao.StudentEntity;
import edu.icet.assignment01.dto.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {

    public ResponseEntity<Student> createStudent(Student student);
    public List <Student> getAllStudents();
    public Iterable<StudentEntity> getAllStudent();

}
