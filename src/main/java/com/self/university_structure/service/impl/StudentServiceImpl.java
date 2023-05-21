package com.self.university_structure.service.impl;

import com.self.university_structure.dto.ResponseDto;
import com.self.university_structure.entity.Student;
import com.self.university_structure.repository.StudentRepository;
import com.self.university_structure.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;


    @Override
    public ResponseDto<Long> create(Student student) {
        return null;
    }

    @Override
    public ResponseDto<Student> getById(Long id) {
        return null;
    }

    @Override
    public ResponseDto<Long> update(Student student) {
        return null;
    }

    @Override
    public ResponseDto<Long> delete(Long id) {
        return null;
    }
}
