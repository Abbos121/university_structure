package com.self.university_structure.repository.custom.impl;

import com.self.university_structure.entity.custom.GroupStatsCustomDto;
import com.self.university_structure.entity.custom.GroupStudentsScoresDto;
import com.self.university_structure.repository.custom.GroupCustomRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GroupCustomRepoImpl implements GroupCustomRepo {

    @PersistenceContext
    private EntityManager entityManager;

    public List<GroupStatsCustomDto> getGroupStatsByFaculty(Long facultyId){
        String queryStr = "select g.id as id, \n" +
                "       g.name as group_name,\n" +
                "       count(s.id) as student_count\n" +
                "from faculty f\n" +
                "         left join groups g on f.id = g.faculty_id\n" +
                "         left join student s on g.id = s.group_id\n" +
                "where f.id = :faculty_id\n" +
                "group by g.name, g.id";

        var query = entityManager.createNativeQuery(queryStr, GroupStatsCustomDto.class);
        query.setParameter("faculty_id", facultyId);
        var resultList = query.getResultList();
        return resultList;
    }

    @Override
    public List<GroupStudentsScoresDto> getStudentsScoresByGroup(Long groupId) {
        String queryStr = "select s.id, s.full_name, sum(m.score) as total_score\n" +
                "from groups g\n" +
                "         inner join student s on g.id = s.group_id\n" +
                "         inner join mark m on s.id = m.student_id\n" +
                "where g.id = :group_id\n" +
                "group by s.id, s.full_name\n" +
                "order by sum(m.score) desc";

        var query = entityManager.createNativeQuery(queryStr, GroupStudentsScoresDto.class);
        query.setParameter("group_id", groupId);
        var resultList = query.getResultList();
        return resultList;
    }


}
