package com.self.university_structure.repository.custom.impl;

import com.self.university_structure.entity.custom.GroupStatsCustomDto;
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
        String queryStr = "select uuid_generate_v1() as id, \n" +
                "       g.name as group_name,\n" +
                "       count(s.id) as student_count\n" +
                "from faculty f\n" +
                "         left join \"group\" g on f.id = g.faculty_id\n" +
                "         left join student s on g.id = s.group_id\n" +
                "where f.id = :faculty_id\n" +
                "group by g.name";

        var query = entityManager.createQuery(queryStr, GroupStatsCustomDto.class);
        query.setParameter("faculty_id", facultyId);
        var resultList = query.getResultList();
        return resultList;
    }
}
