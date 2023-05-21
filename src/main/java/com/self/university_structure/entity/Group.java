package com.self.university_structure.entity;

import com.self.university_structure.enums.GroupLanguage;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "\"GROUP\"")
public class Group extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @OneToOne(mappedBy = "group", cascade = CascadeType.ALL)
    private Journal journal;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LANGUAGE")
    @Enumerated(value = EnumType.STRING)
    private GroupLanguage language;
}
