package com.self.university_structure.service;

import com.self.university_structure.dto.ResponseDto;
import com.self.university_structure.dto.request.StudentRequestDto;
import com.self.university_structure.entity.Student;
import com.self.university_structure.entity.custom.StudentInfoCustomDto;

import java.util.List;

public interface StudentService extends BaseService<Student, StudentRequestDto> {
    ResponseDto<List<StudentInfoCustomDto>> findByName(String name);
}
