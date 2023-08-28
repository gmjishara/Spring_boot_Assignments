package edu.icet.assignment01.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    int indexNumber;
    String firstName;
    String lastName;
    int age;
    String gender;
    String address;
    String email;
    String phoneNumber;
    String university;
    String institute;
    String batch;

}
