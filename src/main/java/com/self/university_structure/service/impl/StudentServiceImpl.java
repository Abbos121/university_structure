package com.self.university_structure.service.impl;

import com.self.university_structure.dto.ResponseDto;
import com.self.university_structure.dto.request.StudentRequestDto;
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
    public ResponseDto<Long> create(StudentRequestDto dto) {
        Student student = new Student();
        var save = repository.save(student);
        return new ResponseDto<>(true, 1, "created", save.getId());
    }

    @Override
    public ResponseDto<Student> getById(Long id) {
        var student = repository.findById(id);
        return new ResponseDto<>(true, 1, "success", student.get());

    }

    @Override
    public ResponseDto<Long> update(StudentRequestDto dto) {
        Student student = new Student();
        var save = repository.save(student);
        return new ResponseDto<>(true, 1, "updated", save.getId());
    }

    @Override
    public ResponseDto<Long> delete(Long id) {
        repository.deleteById(id);
        return new ResponseDto<>(true, 1, "deleted", id);
    }
}
