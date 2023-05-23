package com.self.university_structure.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UniversityRequestDto {
    private Long id; // null if used for creating, otherwise, I mean for updating, it shouldn't be null

    @NotNull(message = "University name cannot be null")
    private String name;

    private String address;

    @Pattern(regexp = "^(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[0-2])/\\d{4}$", message = "Date format should be like 'dd/MM/yyyy'")
    private String openedDate;
}
