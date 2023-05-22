package com.self.university_structure.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "FACULTY")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Faculty extends BaseEntity {
    @Column(name = "NAME")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UNIVERSITY_ID")
    private University university;
}