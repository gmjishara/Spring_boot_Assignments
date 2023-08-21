package edu.icet.assignment01.service;

import edu.icet.assignment01.dao.StudentEntity;
import edu.icet.assignment01.dto.Student;
import edu.icet.assignment01.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;
    @Value("${student.institute}")
    String institute;
    @Override
    public void createStudent(Student student) {
        StudentEntity studentEntity=new StudentEntity();

        studentEntity.setFirstName(student.getFirstName());
        studentEntity.setLastName(student.getLastName());
        studentEntity.setAge(student.getAge());
        studentEntity.setGender(student.getGender());
        studentEntity.setAddress(student.getAddress());
        studentEntity.setEmail(student.getEmail());
        studentEntity.setPhoneNumber(student.getPhoneNumber());
        studentEntity.setUniversity(student.getUniversity());
        studentEntity.setInstitute(institute);
        studentEntity.setCourse(student.getCourse());
        studentEntity.setFee(student.getFee());

        studentRepository.save(studentEntity);
    }
}
