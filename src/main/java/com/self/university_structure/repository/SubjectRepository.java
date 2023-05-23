package com.self.university_structure.repository;

import com.self.university_structure.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository  extends JpaRepository<Subject, Long> {
    @Query(value = "SELECT sb.*\n" +
            "FROM student s\n" +
            "         inner join \"group\" g on g.id = s.group_id\n" +
            "         inner join journal j on g.id = j.group_id\n" +
            "         inner join journal_subject js on j.id = js.journal_id\n" +
            "         inner join subject sb on sb.id = js.subject_id\n" +
            "where s.id = :student_id", nativeQuery = true)
    List<Subject> getByStudentId(@Param("student_id") Long studentId);
}
