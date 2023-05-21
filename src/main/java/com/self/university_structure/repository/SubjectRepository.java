package com.self.university_structure.repository;

import com.self.university_structure.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository  extends JpaRepository<Subject, Long> {
}
