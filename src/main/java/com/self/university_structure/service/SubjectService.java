package com.self.university_structure.service;

import com.self.university_structure.dto.ResponseDto;
import com.self.university_structure.dto.request.SubjectRequestDto;
import com.self.university_structure.entity.Subject;

import java.util.List;

public interface SubjectService extends BaseService<Subject, SubjectRequestDto> {
    ResponseDto<List<Subject>> getSubjectsByStudentId(Long studentId);
}
