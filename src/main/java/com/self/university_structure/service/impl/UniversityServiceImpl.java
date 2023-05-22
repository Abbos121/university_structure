package com.self.university_structure.service.impl;

import com.self.university_structure.dto.ResponseDto;
import com.self.university_structure.dto.request.UniversityRequestDto;
import com.self.university_structure.entity.University;
import com.self.university_structure.exception.ResourceNotFoundException;
import com.self.university_structure.repository.UniversityRepository;
import com.self.university_structure.service.UniversityService;
import com.self.university_structure.utils.DateHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UniversityServiceImpl implements UniversityService {

    private final UniversityRepository repository;

    @Override
    public ResponseDto<Long> create(UniversityRequestDto dto) {
        University university = new University();
        university.setName(dto.getName());
        university.setAddress(dto.getAddress());
        university.setOpenedDate(DateHelper.convertStringToDate(dto.getOpenedDate(), "dd/MM/yyyy"));
        university.setCreatedAt(LocalDateTime.now());
        var save = repository.save(university);
        return new ResponseDto<>(true, 1, "created", save.getId());
    }

    @Override
    public ResponseDto<University> getById(Long id) {
        var uni = repository.findById(id);
        return new ResponseDto<>(true, 1, "success", uni.get());
    }

    @Override
    public ResponseDto<Long> update(UniversityRequestDto dto) {
        var university = repository.findById(dto.getId()).get();
        if (university == null)
            throw new ResourceNotFoundException("University not found");
        university.setId(dto.getId());
        university.setName(dto.getName());
        university.setAddress(dto.getAddress());
        university.setOpenedDate(DateHelper.convertStringToDate(dto.getOpenedDate(), "dd/MM/yyyy"));
        university.setUpdatedAt(LocalDateTime.now());
        var save = repository.save(university);
        return new ResponseDto<>(true, 1, "updated", save.getId());
    }

    @Override
    public ResponseDto<Long> delete(Long id) {
        repository.deleteById(id);
        return new ResponseDto<>(true, 1, "deleted", id);
    }
}
