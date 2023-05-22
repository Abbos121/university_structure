package com.self.university_structure.exception.handler;

import com.self.university_structure.dto.ResponseDto;
import com.self.university_structure.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author Abbos_Akramov
 */

@RestControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

    // THIS METHOD HANDLES MethodArgumentNotValidException TYPE OF EXCEPTIONS
    // AND RETURNS A USER FRIENDLY MESSAGES TO CLIENTS

//    @Override
//    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//
//        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseDto> handleCustomException(ResourceNotFoundException exception) {
        return ResponseEntity.ok(new ResponseDto(false, 0, exception.getReason()));
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
