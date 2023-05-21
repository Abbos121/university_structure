package com.self.university_structure.service.impl;

import com.self.university_structure.dto.ResponseDto;
import com.self.university_structure.dto.request.SubjectRequestDto;
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
    public ResponseDto<Long> create(SubjectRequestDto dto) {
        Subject subject = new Subject();
        var save = repository.save(subject);
        return new ResponseDto<>(true, 1, "created", save.getId());
    }

    @Override
    public ResponseDto<Subject> getById(Long id) {
        var uni = repository.findById(id);
        return new ResponseDto<>(true, 1, "success", uni.get());
    }

    @Override
    public ResponseDto<Long> update(SubjectRequestDto dto) {
        Subject subject = new Subject();
        var save = repository.save(subject);
        return new ResponseDto<>(true, 1, "updated", save.getId());
    }

    @Override
    public ResponseDto<Long> delete(Long id) {
        repository.deleteById(id);
        return new ResponseDto<>(true, 1, "deleted", id);
    }
}
