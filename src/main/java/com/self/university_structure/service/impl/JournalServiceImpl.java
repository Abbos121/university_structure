package com.self.university_structure.service.impl;

import com.self.university_structure.dto.ResponseDto;
import com.self.university_structure.entity.Journal;
import com.self.university_structure.repository.JournalRepository;
import com.self.university_structure.service.JournalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JournalServiceImpl implements JournalService {

    private final JournalRepository repository;

    @Override
    public ResponseDto<Long> create(Journal journal) {
        return null;
    }

    @Override
    public ResponseDto<Journal> getById(Long id) {
        return null;
    }

    @Override
    public ResponseDto<Long> update(Journal journal) {
        return null;
    }

    @Override
    public ResponseDto<Long> delete(Long id) {
        return null;
    }
}
