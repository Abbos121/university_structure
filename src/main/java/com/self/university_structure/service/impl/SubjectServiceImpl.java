package com.self.university_structure.service.impl;

import com.self.university_structure.dto.ResponseDto;
import com.self.university_structure.entity.Subject;
import com.self.university_structure.repository.SubjectRepository;
import com.self.university_structure.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository repository;

    @Override
    public ResponseDto<Long> create(Subject subject) {
        return null;
    }

    @Override
    public ResponseDto<Subject> getById(Long id) {
        return null;
    }

    @Override
    public ResponseDto<Long> update(Subject subject) {
        return null;
    }

    @Override
    public ResponseDto<Long> delete(Long id) {
        return null;
    }
}
