package com.self.university_structure.repository.custom;

import com.self.university_structure.entity.custom.GroupStatsCustomDto;

import java.util.List;

public interface GroupCustomRepo {
    List<GroupStatsCustomDto> getGroupStatsByFaculty(Long facultyId);
}
