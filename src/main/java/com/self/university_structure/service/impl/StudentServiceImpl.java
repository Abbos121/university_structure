package com.self.university_structure.service.impl;

import com.self.university_structure.dto.ResponseDto;
import com.self.university_structure.dto.request.StudentRequestDto;
import com.self.university_structure.entity.Student;
import com.self.university_structure.entity.custom.StudentInfoCustomDto;
import com.self.university_structure.exception.ResourceNotFoundException;
import com.self.university_structure.repository.GroupRepository;
import com.self.university_structure.repository.StudentRepository;
import com.self.university_structure.service.StudentService;
import com.self.university_structure.utils.DateHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;
    private final GroupRepository groupRepository;


    @Override
    public ResponseDto<Long> create(StudentRequestDto dto) {
        var group = groupRepository.findById(dto.getGroupId());
        if (group.isEmpty()) {
            throw new ResourceNotFoundException("Group not found");
        }

        Student student = new Student();
        student.setGroup(group.get());
        student.setFullName(dto.getFullName());
        student.setGender(dto.getGender());
        student.setDateOfBirth(DateHelper.convertStringToDate(dto.getDateOfBirth(), "dd/MM/yyyy"));
        student = repository.save(student);
        return new ResponseDto<>(true, 1, "created", student.getId());
    }

    @Override
    public ResponseDto<Student> getById(Long id) {
        var student = repository.findById(id);
        if (student.isEmpty())
            throw new ResourceNotFoundException("Student not found");
        return new ResponseDto<>(true, 1, "success", student.get());

    }

    @Override
    public ResponseDto<Long> update(StudentRequestDto dto) {
        var std = repository.findById(dto.getId());
        if (std.isEmpty())
            throw new ResourceNotFoundException("Student not found");
        var group = groupRepository.findById(dto.getGroupId());
        if (group.isEmpty())
            throw new ResourceNotFoundException("Group not found");
        Student student = std.get();
        student.setUpdatedAt(LocalDateTime.now());
        student.setGender(dto.getGender());
        student.setGroup(group.get());
        student.setFullName(dto.getFullName());
        student.setDateOfBirth(DateHelper.convertStringToDate(dto.getDateOfBirth(), "dd/MM/yyyy"));
        repository.save(student);
        return new ResponseDto<>(true, 1, "updated", student.getId());
    }

    @Override
    public ResponseDto<Long> delete(Long id) {
        repository.deleteById(id);
        return new ResponseDto<>(true, 1, "deleted", id);
    }

    @Override
    public ResponseDto<List<StudentInfoCustomDto>> findByName(String name) {
        var studentInfoByName = repository.getStudentInfoByName(name);
        return new ResponseDto<>(true, 1, "success", studentInfoByName);
    }
}
