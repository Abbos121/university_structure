package com.self.university_structure.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class JournalRequestDto {
    private Long id;
    @NotNull(message = "Group id cannot be null")
    private Long groupId;
    @NotNull(message = "Name id cannot be null")
    private String name;
}
