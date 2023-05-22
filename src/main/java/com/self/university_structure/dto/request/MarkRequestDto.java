package com.self.university_structure.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MarkRequestDto {
    private Long id;
    @NotNull(message = "student id cannot be null")
    private Long studentId;
    @NotNull(message = "subject id cannot be null")
    private Long subjectId;
    @NotNull(message = "score id cannot be null")
    private Double score;
    @NotNull(message = "semester number id cannot be null")
    private Integer semesterNumber;
}
