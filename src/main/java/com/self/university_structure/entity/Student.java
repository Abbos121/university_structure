package com.self.university_structure.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "STUDENT")
public class Student extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    @Column(name = "FULL_NAME")
    private String fullName;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "GENDER")
    private Integer gender;
}
