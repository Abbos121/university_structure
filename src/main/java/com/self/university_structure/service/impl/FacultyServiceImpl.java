package com.self.university_structure.service.impl;

import com.self.university_structure.dto.ResponseDto;
import com.self.university_structure.dto.request.FacultyRequestDto;
import com.self.university_structure.entity.Faculty;
import com.self.university_structure.repository.FacultyRepository;
import com.self.university_structure.service.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository repository;

    @Override
    public ResponseDto<Long> create(FacultyRequestDto faculty) {
        return null;
    }

    @Override
    public ResponseDto<Faculty> getById(Long id) {
        return null;
    }

    @Override
    public ResponseDto<Long> update(FacultyRequestDto faculty) {
        return null;
    }

    @Override
    public ResponseDto<Long> delete(Long id) {
        return null;
    }
}
