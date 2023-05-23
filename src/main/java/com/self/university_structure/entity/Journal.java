package com.self.university_structure.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "JOURNAL")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Journal extends BaseEntity {
    @Column(name = "NAME")
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GROUP_ID")
    private Group group;

    @ManyToMany(mappedBy = "journals")
    private List<Subject> subjects = new ArrayList<>();
}
