package com.self.university_structure.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.function.Supplier;

@AllArgsConstructor
@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException {
    private String reason;
}
