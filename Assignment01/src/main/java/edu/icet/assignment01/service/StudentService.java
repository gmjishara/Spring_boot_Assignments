package edu.icet.assignment01.service;

import edu.icet.assignment01.dao.StudentEntity;
import edu.icet.assignment01.dto.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface StudentService {

    public ResponseEntity<StudentEntity> createStudent(Student student) throws IOException;
    public List <Student> getAllStudents();
    public Iterable<StudentEntity> getAllStudent();

}
