package edu.icet.assignment01.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
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
