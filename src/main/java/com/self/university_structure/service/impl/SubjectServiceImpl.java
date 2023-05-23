package com.self.university_structure.service.impl;

import com.self.university_structure.dto.ResponseDto;
import com.self.university_structure.dto.request.SubjectRequestDto;
import com.self.university_structure.entity.Journal;
import com.self.university_structure.entity.Subject;
import com.self.university_structure.exception.ResourceNotFoundException;
import com.self.university_structure.repository.JournalRepository;
import com.self.university_structure.repository.SubjectRepository;
import com.self.university_structure.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository repository;
    private final JournalRepository journalRepository;
    @Override
    public ResponseDto<Long> create(SubjectRequestDto dto) {
        List<Journal> journals = journalRepository.findAllByIdSet(dto.getJournalIds());
        Subject subject = new Subject();
        subject.setName(dto.getName());
        subject.setJournals(journals);
        var save = repository.save(subject);
        return new ResponseDto<>(true, 1, "created", save.getId());
    }

    @Override
    public ResponseDto<Subject> getById(Long id) {
        var subject = repository.findById(id);
        if (subject.isPresent())
            return new ResponseDto<>(true, 1, "success", subject.get());
        else
            throw new ResourceNotFoundException("Subject not found");
    }

    @Override
    public ResponseDto<Long> update(SubjectRequestDto dto) {
        var subject = repository.findById(dto.getId());
        if (subject.isEmpty())
            throw new ResourceNotFoundException("Subject not found");
        List<Journal> journals = journalRepository.findAllByIdSet(dto.getJournalIds());
        var subject1 = subject.get();
        subject1.setJournals(journals);
        subject1.setName(dto.getName());
        subject1.setUpdatedAt(LocalDateTime.now());
        return new ResponseDto<>(true, 1, "updated", subject1.getId());
    }

    @Override
    public ResponseDto<Long> delete(Long id) {
        repository.deleteById(id);
        return new ResponseDto<>(true, 1, "deleted", id);
    }

    @Override
    public ResponseDto<List<Subject>> getSubjectsByStudentId(@RequestParam(name = "studentId") Long studentId) {
        var subjects = repository.getByStudentId(studentId);
        return new ResponseDto<>(true, 1, "success", subjects);
    }
}
