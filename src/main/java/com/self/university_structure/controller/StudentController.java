package com.self.university_structure.controller;

import com.self.university_structure.dto.ResponseDto;
import com.self.university_structure.dto.request.StudentRequestDto;
import com.self.university_structure.entity.Student;
import com.self.university_structure.entity.custom.StudentInfoCustomDto;
import com.self.university_structure.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentService service;

    @PostMapping
    public ResponseEntity<ResponseDto<Long>> create(@RequestBody @Valid StudentRequestDto student) {
        return ResponseEntity.ok(service.create(student));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<Student>> getById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping
    public ResponseEntity<ResponseDto<Long>> update(@RequestBody @Valid StudentRequestDto student) {
        return ResponseEntity.ok(service.update(student));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto<Long>> delete(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping("/search-by-name")
    public ResponseEntity<ResponseDto<List<StudentInfoCustomDto>>> getStudentsByName(@RequestParam("name") String name) {
        return ResponseEntity.ok(service.findByName(name));
    }
}
