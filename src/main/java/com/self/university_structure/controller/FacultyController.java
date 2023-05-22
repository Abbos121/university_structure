package com.self.university_structure.controller;


import com.self.university_structure.dto.ResponseDto;
import com.self.university_structure.dto.request.FacultyRequestDto;
import com.self.university_structure.entity.Faculty;
import com.self.university_structure.service.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService service;

    @PostMapping
    public ResponseEntity<ResponseDto<Long>> create(@RequestBody FacultyRequestDto faculty) {
        return ResponseEntity.ok(service.create(faculty));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<Faculty>> getById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping
    public ResponseEntity<ResponseDto<Long>> update(@RequestBody FacultyRequestDto faculty) {
        return ResponseEntity.ok(service.update(faculty));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto<Long>> delete(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(service.delete(id));
    }
}
