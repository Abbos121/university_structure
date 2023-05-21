package com.self.university_structure.service.impl;

import com.self.university_structure.dto.ResponseDto;
import com.self.university_structure.dto.request.GroupRequestDto;
import com.self.university_structure.entity.Group;
import com.self.university_structure.repository.GroupRepository;
import com.self.university_structure.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private GroupRepository repository;

    @Override
    public ResponseDto<Long> create(GroupRequestDto group) {
        return null;
    }

    @Override
    public ResponseDto<Group> getById(Long id) {
        return null;
    }

    @Override
    public ResponseDto<Long> update(GroupRequestDto group) {
        return null;
    }

    @Override
    public ResponseDto<Long> delete(Long id) {
        return null;
    }
}
