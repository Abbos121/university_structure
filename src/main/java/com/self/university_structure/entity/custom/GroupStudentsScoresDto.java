package com.self.university_structure.entity.custom;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class GroupStudentsScoresDto {
    @Id
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "total_score")
    private String totalScore;
}
