package com.self.university_structure.repository.custom.impl;

import com.self.university_structure.entity.custom.GroupStatsCustomDto;
import com.self.university_structure.entity.custom.StudentInfoCustomDto;
import com.self.university_structure.repository.custom.StudentCustomRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentCustomRepoImpl implements StudentCustomRepo {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<StudentInfoCustomDto> getStudentInfoByName(String name) {
        String queryStr = "select s.id, s.full_name,\n" +
                "       g.name                                                      group_name,\n" +
                "       f.name                                                      faculty_name,\n" +
                "       case s.gender when 1 then 'MALE' when 2 then 'FEMAL' end as gender,\n" +
                "       s.date_of_birth\n" +
                "from student s\n" +
                "         inner join groups g on g.id = s.group_id\n" +
                "         inner join faculty f on g.faculty_id = f.id\n" +
                "where lower(s.full_name) like ('%' || (:name) || '%')";

        var query = entityManager.createNativeQuery(queryStr, StudentInfoCustomDto.class);
        query.setParameter("name", name.toLowerCase());
        var resultList = query.getResultList();
        return resultList;
    }
}
