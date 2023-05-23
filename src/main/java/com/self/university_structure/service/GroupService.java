package com.self.university_structure.service;

import com.self.university_structure.dto.ResponseDto;
import com.self.university_structure.dto.request.GroupRequestDto;
import com.self.university_structure.entity.Group;

public interface GroupService extends BaseService<Group, GroupRequestDto> {
    ResponseDto getGroupStatsByFaculty(Long facultyId);
}
