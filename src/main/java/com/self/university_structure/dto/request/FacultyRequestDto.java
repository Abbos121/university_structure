package com.self.university_structure.dto.request;


import lombok.Data;

@Data
public class FacultyRequestDto {
    private Long id;
    private String name;
    private Long universityId;
}
