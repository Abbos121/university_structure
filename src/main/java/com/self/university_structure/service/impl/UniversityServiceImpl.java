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
        var save = repository.save(university);
        return new ResponseDto<>(true, 1, "created", save.getId());
    }

    @Override
    public ResponseDto<University> getById(Long id) {
        var uni = repository.findById(id);
        return new ResponseDto<>(true, 1, "success", uni.get());
    }

    @Override
    public ResponseDto<Long> update(University university) {
        var save = repository.save(university);
        return new ResponseDto<>(true, 1, "updated", save.getId());
    }

    @Override
    public ResponseDto<Long> delete(Long id) {
        repository.deleteById(id);
        return new ResponseDto<>(true, 1, "deleted", id);
    }
}
