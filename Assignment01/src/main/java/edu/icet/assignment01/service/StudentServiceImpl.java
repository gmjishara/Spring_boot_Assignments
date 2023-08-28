package edu.icet.assignment01.service;

import edu.icet.assignment01.dao.StudentEntity;
import edu.icet.assignment01.dto.Student;
import edu.icet.assignment01.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Value("${student.institute}")
    String institute;

    public ResponseEntity<Student> createStudent(Student student) {
        StudentEntity studentEntity = new StudentEntity();

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
        studentEntity.setInstitute(institute);

        studentRepository.save(studentEntity);
        if(studentRepository.save(studentEntity)!=null){
            return ResponseEntity.ok(student);
        } else return ResponseEntity.badRequest().build();
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();

        Iterable<StudentEntity> studentsIteration = studentRepository.findAll();

        while (studentsIteration.iterator().hasNext()) {
            StudentEntity studentEntity = studentsIteration.iterator().next();
            students.add(Student.builder().indexNumber(studentEntity.getIndexNumber()).firstName(studentEntity.getFirstName()).lastName(studentEntity.getLastName()).age(studentEntity.getAge()).gender(studentEntity.getGender()).address(studentEntity.getAddress()).email(studentEntity.getEmail()).phoneNumber(studentEntity.getPhoneNumber()).university(studentEntity.getUniversity()).institute(studentEntity.getInstitute()).batch(studentEntity.getBatch()).build());
        }

        return students;
    }

    public Iterable<StudentEntity> getAllStudent(){
        return studentRepository.findAll();
    }

}
