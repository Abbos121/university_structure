package com.self.university_structure.service.impl;

import com.self.university_structure.dto.ResponseDto;
import com.self.university_structure.dto.request.GroupRequestDto;
import com.self.university_structure.entity.Group;
import com.self.university_structure.entity.custom.GroupStatsCustomDto;
import com.self.university_structure.enums.GroupLanguage;
import com.self.university_structure.exception.ResourceNotFoundException;
import com.self.university_structure.repository.FacultyRepository;
import com.self.university_structure.repository.GroupRepository;
import com.self.university_structure.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository repository;
    private final FacultyRepository facultyRepository;

    @Override
    public ResponseDto<Long> create(GroupRequestDto group) {
        var faculty = facultyRepository.findById(group.getFacultyId());
        if (faculty.isEmpty())
            throw new ResourceNotFoundException("Faculty not found");
        Group save = new Group();
        save.setFaculty(faculty.get());
        save.setName(group.getName());
        save.setLanguage(GroupLanguage.getByCode(group.getLanguageCode()));
        save = repository.save(save);
        return new ResponseDto<>(true, 1, "created", save.getId());
    }

    @Override
    public ResponseDto<Group> getById(Long id) {
        var group = repository.findById(id);
        if (group.isPresent())
            return new ResponseDto<>(true, 1, "success", group.get());
        else
            throw new ResourceNotFoundException("Group not found");
    }

    @Override
    public ResponseDto<Long> update(GroupRequestDto group) {
        var updateG = repository.findById(group.getId());
        if (updateG.isEmpty())
            throw new ResourceNotFoundException("Group not found");

        var fac = facultyRepository.findById(group.getFacultyId());
        if (fac.isEmpty())
            throw new ResourceNotFoundException("Faculty not found with " + group.getFacultyId() + " id");

        var update = updateG.get();
        update.setName(group.getName());
        update.setFaculty(fac.get());
        update.setLanguage(GroupLanguage.getByCode(group.getLanguageCode()));
        update.setUpdatedAt(LocalDateTime.now());
        repository.save(update);
        return new ResponseDto<>(true, 1, "updated", update.getId());

    }

    @Override
    public ResponseDto<Long> delete(Long id) {
        repository.deleteById(id);
        return new ResponseDto<>(true, 1, "success", id);
    }

    @Override
    public ResponseDto getGroupStatsByFaculty(Long facultyId) {
        var groupStatsByFaculty = repository.getGroupStatsByFaculty(facultyId);
        return new ResponseDto(true, 1, "success", groupStatsByFaculty);
    }
}
