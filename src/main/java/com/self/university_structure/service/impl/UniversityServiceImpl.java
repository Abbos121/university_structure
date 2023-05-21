package com.self.university_structure.service.impl;

import com.self.university_structure.dto.ResponseDto;
import com.self.university_structure.entity.University;
import com.self.university_structure.repository.UniversityRepository;
import com.self.university_structure.service.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UniversityServiceImpl implements UniversityService {

    private final UniversityRepository repository;

    @Override
    public ResponseDto<Long> create(University university) {
        return null;
    }

    @Override
    public ResponseDto<University> getById(Long id) {
        return null;
    }

    @Override
    public ResponseDto<Long> update(University university) {
        return null;
    }

    @Override
    public ResponseDto<Long> delete(Long id) {
        return null;
    }
}
