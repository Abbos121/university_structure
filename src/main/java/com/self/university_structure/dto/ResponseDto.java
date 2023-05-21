package com.self.university_structure.dto;

import lombok.Data;

@Data
public class ResponseDto <T> {
    private boolean success;
    private Integer code;
    private String message;
    private T data;
}
