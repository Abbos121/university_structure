package com.self.university_structure.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseDto <T> {
    private boolean success;
    private Integer code;
    private String message;
    private T data;

    public ResponseDto(boolean success, Integer code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
