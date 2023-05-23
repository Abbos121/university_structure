package com.self.university_structure.service.impl;

import com.self.university_structure.dto.ResponseDto;
import com.self.university_structure.dto.request.MarkRequestDto;
import com.self.university_structure.entity.Mark;
import com.self.university_structure.entity.Student;
import com.self.university_structure.exception.ResourceNotFoundException;
import com.self.university_structure.repository.MarkRepository;
import com.self.university_structure.repository.StudentRepository;
import com.self.university_structure.repository.SubjectRepository;
import com.self.university_structure.service.MarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MarkServiceImpl implements MarkService {

    private final MarkRepository repository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    @Override
    public ResponseDto<Long> create(MarkRequestDto mark) {
        var student = studentRepository.findById(mark.getStudentId());
        if (student.isEmpty())
            throw new ResourceNotFoundException("Student not found");

        var subject = subjectRepository.findById(mark.getStudentId());
        if (subject.isEmpty())
            throw new ResourceNotFoundException("subject not found");

        Mark mark1 = new Mark();
        mark1.setScore(mark.getScore());
        mark1.setStudent(student.get());
        mark1.setSubject(subject.get());
        mark1.setSemesterNumber(mark.getSemesterNumber());
        mark1 = repository.save(mark1);
        return new ResponseDto<>(true, 1, "success", mark1.getId());
    }

    @Override
    public ResponseDto<Mark> getById(Long id) {
        var mark = repository.findById(id);
        if (mark.isPresent())
            return new ResponseDto<>(true, 1, "success", mark.get());
        else
            throw new ResourceNotFoundException("Mark not found");
    }

    @Override
    public ResponseDto<Long> update(MarkRequestDto mark) {
        var student = studentRepository.findById(mark.getStudentId());
        if (student.isEmpty())
            throw new ResourceNotFoundException("Student not found");

        var subject = subjectRepository.findById(mark.getStudentId());
        if (subject.isEmpty())
            throw new ResourceNotFoundException("subject not found");

        var byId = repository.findById(mark.getId());
        if (byId.isEmpty())
            throw new ResourceNotFoundException("Mark not found");
        var mark1 = byId.get();
        mark1.setScore(mark.getScore());
        mark1.setStudent(student.get());
        mark1.setSubject(subject.get());
        mark1.setSemesterNumber(mark.getSemesterNumber());
        mark1.setUpdatedAt(LocalDateTime.now());
        repository.save(mark1);
        return new ResponseDto<>(true, 1, "updated", mark.getId());
    }

    @Override
    public ResponseDto<Long> delete(Long id) {
        repository.deleteById(id);
        return new ResponseDto<>(true, 1, "success", id);
    }
}
