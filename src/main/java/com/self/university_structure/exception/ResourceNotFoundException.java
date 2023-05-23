package com.self.university_structure.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.function.Supplier;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ResourceNotFoundException extends RuntimeException {
    private String reason;
}
