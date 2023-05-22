package com.self.university_structure.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GroupRequestDto {
    private Long id;

    @NotNull(message = "cannot connected to faculty")
    private Long facultyId;

    private String name;

    private Integer languageCode;
}
