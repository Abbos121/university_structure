package com.self.university_structure.controller;

import com.self.university_structure.dto.ResponseDto;
import com.self.university_structure.dto.request.JournalRequestDto;
import com.self.university_structure.entity.Journal;
import com.self.university_structure.service.JournalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/journal")
public class JournalController {

    private final JournalService service;

    @PostMapping
    public ResponseEntity<ResponseDto<Long>> create(@RequestBody JournalRequestDto journal) {
        return ResponseEntity.ok(service.create(journal));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<Journal>> getById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping
    public ResponseEntity<ResponseDto<Long>> update(@RequestBody JournalRequestDto journal) {
        return ResponseEntity.ok(service.update(journal));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto<Long>> delete(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(service.delete(id));
    }
}
