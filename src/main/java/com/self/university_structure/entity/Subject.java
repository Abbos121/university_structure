package com.self.university_structure.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "SUBJECT")
public class Subject extends BaseEntity {
    @Column(name = "NAME")
    private String name;

    @ManyToMany
    @JoinTable(name = "JOURNAL_SUBJECT",
    joinColumns = @JoinColumn(name = "SUBJECT_ID"),
    inverseJoinColumns = @JoinColumn(name = "JOURNAL_ID"))
    private List<Journal> journals;
}
