package com.self.university_structure.entity.custom;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class StudentInfoCustomDto {
    @Id
    private Long id;

    @Column(name = "FULL_NAME")
    private String fullName;

    @Column(name = "GROUP_NAME")
    private String groupName;

    @Column(name = "FACULTY_NAME")
    private String facultyName;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "DATE_OF_BIRTH")
    private String dateOfBirth;
}
