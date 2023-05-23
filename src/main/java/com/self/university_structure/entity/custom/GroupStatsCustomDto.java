package com.self.university_structure.entity.custom;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class GroupStatsCustomDto {
    @Id
    @JsonIgnore
    private String id;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "student_count")
    private Long studentCount;
}
