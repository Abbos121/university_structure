package com.self.university_structure.service.impl;

import com.self.university_structure.dto.ResponseDto;
import com.self.university_structure.dto.request.FacultyRequestDto;
import com.self.university_structure.entity.Faculty;
import com.self.university_structure.entity.University;
import com.self.university_structure.exception.ResourceNotFoundException;
import com.self.university_structure.repository.FacultyRepository;
import com.self.university_structure.repository.UniversityRepository;
import com.self.university_structure.service.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository repository;
    private final UniversityRepository universityRepository;

    @Override
    public ResponseDto<Long> create(FacultyRequestDto faculty) {
        var uni = universityRepository.findById(faculty.getUniversityId());
        if (uni.isEmpty())
            throw new ResourceNotFoundException("University not found with " + faculty.getUniversityId() + " id");

        Faculty fac = new Faculty();
        fac.setUniversity(uni.get());
        fac.setName(faculty.getName());
        fac = repository.save(fac);
        return new ResponseDto<>(true, 1, "created", faculty.getId());
    }

    @Override
    public ResponseDto<Faculty> getById(Long id) {
        var faculty = repository.findById(id);
        if (faculty.isPresent())
            return new ResponseDto<>(true, 1, "success", faculty.get());
        else
            throw new ResourceNotFoundException("Faculty not found");
    }

    @Override
    public ResponseDto<Long> update(FacultyRequestDto faculty) {
        var fac = repository.findById(faculty.getId());
        if (fac.isEmpty())
            throw new ResourceNotFoundException("Faculty not found");

        var uni = universityRepository.findById(faculty.getUniversityId());
        if (uni.isEmpty())
            throw new ResourceNotFoundException("University not found with " + faculty.getUniversityId() + " id");

        var update = fac.get();
        update.setName(faculty.getName());
        update.setUniversity(uni.get());
        update.setUpdatedAt(LocalDateTime.now());
        repository.save(update);
        return new ResponseDto<>(true, 1, "updated", update.getId());
    }

    @Override
    public ResponseDto<Long> delete(Long id) {
        repository.deleteById(id);
        return new ResponseDto<>(true, 1, "success", id);
    }
}
