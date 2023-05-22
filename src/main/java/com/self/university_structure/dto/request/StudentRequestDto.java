package com.self.university_structure.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class StudentRequestDto {
    private Long id;
    @NotNull(message = "group id cannot be null")
    private Long groupId;
    private Integer gender;
    @NotNull(message = "student name mustn't be empty")
    private String fullName;
    @Pattern(regexp = "^(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[0-2])/\\d{4}$", message = "Date format should be like 'dd/MM/yyyy'")
    private String dateOfBirth;
}
