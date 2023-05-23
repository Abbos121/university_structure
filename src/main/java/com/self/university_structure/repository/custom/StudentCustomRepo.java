package com.self.university_structure.repository.custom;

import com.self.university_structure.entity.custom.StudentInfoCustomDto;

import java.util.List;

public interface StudentCustomRepo {
    List<StudentInfoCustomDto> getStudentInfoByName(String name);
}
