package com.self.university_structure.dto.request;

import lombok.Data;

import java.util.Set;

@Data
public class SubjectRequestDto {
    private Long id;
    private String name;
    private Set<Long> journalIds;
}
