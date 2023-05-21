package com.self.university_structure.controller;

import com.self.university_structure.dto.ResponseDto;
import com.self.university_structure.dto.request.UniversityForm;
import com.self.university_structure.entity.University;
import com.self.university_structure.service.UniversityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/university")
public class UniversityController {

    private final UniversityService service;

    @PostMapping
    public ResponseEntity<ResponseDto<Long>> create(@RequestBody @Valid UniversityForm university) {
        return ResponseEntity.ok(service.create(new University(university)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<University>> getById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping
    public ResponseEntity<ResponseDto<Long>> update(@RequestBody @Valid UniversityForm university) {
        return ResponseEntity.ok(service.update(new University(university)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto<Long>> delete(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(service.delete(id));
    }
}
