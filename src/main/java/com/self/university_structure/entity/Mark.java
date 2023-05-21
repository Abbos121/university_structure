package com.self.university_structure.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "MARK")
public class Mark extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    private Subject subject;

    @Column(name = "SCORE")
    private Double score;

    @Column(name = "SEMESTER_NUMBER")
    private Integer semesterNumber;
}
