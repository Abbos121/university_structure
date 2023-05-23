package com.self.university_structure.repository.custom;

import com.self.university_structure.entity.custom.GroupStatsCustomDto;
import com.self.university_structure.entity.custom.GroupStudentsScoresDto;

import java.util.List;

public interface GroupCustomRepo {
    List<GroupStatsCustomDto> getGroupStatsByFaculty(Long facultyId);

    List<GroupStudentsScoresDto> getStudentsScoresByGroup(Long groupId);
}
