package com.self.university_structure.controller;

import com.self.university_structure.dto.ResponseDto;
import com.self.university_structure.dto.request.GroupRequestDto;
import com.self.university_structure.entity.Group;
import com.self.university_structure.service.GroupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/group")
public class GroupController {
    private final GroupService service;

    @PostMapping
    public ResponseEntity<ResponseDto<Long>> create(@RequestBody @Valid GroupRequestDto group) {
        return ResponseEntity.ok(service.create(group));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<Group>> getById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping
    public ResponseEntity<ResponseDto<Long>> update(@RequestBody @Valid GroupRequestDto group) {
        return ResponseEntity.ok(service.update(group));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto<Long>> delete(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping("stats-by-faculty")
    public ResponseEntity<ResponseDto> getGroupStatisticsByFaculty(@RequestParam("facultyId") Long facultyId) {
        return ResponseEntity.ok(service.getGroupStatsByFaculty(facultyId));
    }

    @GetMapping("student-marks")
    public ResponseEntity<ResponseDto> getStudentMarks(@RequestParam("groupId") Long groupId) {
        return ResponseEntity.ok(service.getStudentMarksByGroup(groupId));
    }
}
