package com.self.university_structure.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Abbos_Akramov
 */

@RestControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

    // THIS METHOD HANDLES MethodArgumentNotValidException TYPE OF EXCEPTIONS
    // AND RETURNS A USER FRIENDLY MESSAGES TO CLIENTS
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleExceptionClass(Exception ex, WebRequest request) {
        ex.printStackTrace();
        String resBody;
        resBody = ex.getMessage() != null ? ex.getMessage() : "Kutilmagan nosozlik. Qayta urinib ko'ring!";
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(resBody);
    }

}
