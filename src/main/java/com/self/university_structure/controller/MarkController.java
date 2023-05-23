package com.self.university_structure.controller;

import com.self.university_structure.dto.ResponseDto;
import com.self.university_structure.dto.request.MarkRequestDto;
import com.self.university_structure.entity.Mark;
import com.self.university_structure.entity.Subject;
import com.self.university_structure.service.MarkService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mark")
public class MarkController {

    private final MarkService service;

    @PostMapping
    public ResponseEntity<ResponseDto<Long>> create(@RequestBody @Valid MarkRequestDto nark) {
        return ResponseEntity.ok(service.create(nark));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<Mark>> getById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping
    public ResponseEntity<ResponseDto<Long>> update(@RequestBody @Valid MarkRequestDto mark) {
        return ResponseEntity.ok(service.update(mark));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto<Long>> delete(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(service.delete(id));
    }
}
