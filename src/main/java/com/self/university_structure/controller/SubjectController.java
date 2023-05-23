package com.self.university_structure.controller;

import com.self.university_structure.dto.ResponseDto;
import com.self.university_structure.dto.request.SubjectRequestDto;
import com.self.university_structure.entity.Subject;
import com.self.university_structure.service.SubjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subject")
public class SubjectController {

    private final SubjectService service;

    @PostMapping
    public ResponseEntity<ResponseDto<Long>> create(@RequestBody @Valid SubjectRequestDto subject) {
        return ResponseEntity.ok(service.create(subject));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<Subject>> getById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping
    public ResponseEntity<ResponseDto<Long>> update(@RequestBody @Valid SubjectRequestDto subject) {
        return ResponseEntity.ok(service.update(subject));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto<Long>> delete(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping("subjects-by-student")
    public ResponseEntity<ResponseDto<List<Subject>>> getSubjectsByStudentId(Long studentId) {
        return ResponseEntity.ok(service.getSubjectsByStudentId(studentId));
    }
}
