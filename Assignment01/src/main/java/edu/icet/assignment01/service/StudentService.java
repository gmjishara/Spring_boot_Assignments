package edu.icet.assignment01.service;

import edu.icet.assignment01.dao.StudentEntity;
import edu.icet.assignment01.dto.Student;
import org.springframework.http.ResponseEntity;
import java.io.IOException;


public interface StudentService {

    public ResponseEntity<StudentEntity> createStudent(Student student) throws IOException;

    public Iterable<StudentEntity> getAllStudent();

}
