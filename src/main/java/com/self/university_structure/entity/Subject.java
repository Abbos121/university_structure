package com.self.university_structure.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "SUBJECT")
@JsonIgnoreProperties({"journals"})
public class Subject extends BaseEntity {
    @Column(name = "NAME")
    private String name;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "JOURNAL_SUBJECT",
    joinColumns = @JoinColumn(name = "SUBJECT_ID"),
    inverseJoinColumns = @JoinColumn(name = "JOURNAL_ID"))
    private List<Journal> journals = new ArrayList<>();
}
