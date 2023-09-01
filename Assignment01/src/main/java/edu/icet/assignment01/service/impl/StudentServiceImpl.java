package edu.icet.assignment01.service.impl;

import edu.icet.assignment01.dao.StudentEntity;
import edu.icet.assignment01.dto.Student;
import edu.icet.assignment01.repository.StudentRepository;
import edu.icet.assignment01.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//spring create bean objects by @service annotation
@Service
public class StudentServiceImpl implements StudentService {

    //spring assign StudentRepository type object in runtime
    @Autowired
    StudentRepository studentRepository;

    public ResponseEntity<StudentEntity> createStudent(Student student) throws IOException {
        //create a data access object
        StudentEntity studentEntity = new StudentEntity();

        //pass data of DTO to DAO
        studentEntity.setIndexNumber(student.getIndexNumber());
        studentEntity.setFirstName(student.getFirstName());
        studentEntity.setLastName(student.getLastName());
        studentEntity.setAge(student.getAge());
        studentEntity.setGender(student.getGender());
        studentEntity.setBatch(student.getBatch());
        studentEntity.setAddress(student.getAddress());
        studentEntity.setEmail(student.getEmail());
        studentEntity.setPhoneNumber(student.getPhoneNumber());
        studentEntity.setUniversity(student.getUniversity());
        studentEntity.setInstitute(student.getInstitute());

        //convert image file to string
        MultipartFile imageFile = student.getImage();  //extract image file
        String originalFileName = imageFile.getOriginalFilename(); //get original file name
        studentEntity.setImage(originalFileName); // save file name to the image attribute in studentEntity class

        //save image in the images directory
        byte[] imageBytes = imageFile.getBytes();
        Path imagePath = Paths.get("src/main/resources/static/images", originalFileName);
        Files.write(imagePath, imageBytes);

        //save data of DAO in database
        studentRepository.save(studentEntity);
        return ResponseEntity.ok(studentEntity);
    }

    //view all students
    public Iterable<StudentEntity> getAllStudent() {
        return studentRepository.findAll();
    }

}
