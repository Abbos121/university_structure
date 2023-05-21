package com.self.university_structure.service.impl;

import com.self.university_structure.dto.ResponseDto;
import com.self.university_structure.dto.request.MarkRequestDto;
import com.self.university_structure.entity.Mark;
import com.self.university_structure.repository.MarkRepository;
import com.self.university_structure.service.MarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MarkServiceImpl implements MarkService {

    private final MarkRepository repository;

    @Override
    public ResponseDto<Long> create(MarkRequestDto mark) {
        return null;
    }

    @Override
    public ResponseDto<Mark> getById(Long id) {
        return null;
    }

    @Override
    public ResponseDto<Long> update(MarkRequestDto mark) {
        return null;
    }

    @Override
    public ResponseDto<Long> delete(Long id) {
        return null;
    }
}
