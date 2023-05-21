package com.self.university_structure.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "FACULTY")
@Data
public class Faculty extends BaseEntity {
    @Column(name = "NAME")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UNIVERSITY_ID")
    private University university;
}