package com.self.university_structure.repository;

import com.self.university_structure.entity.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkRepository  extends JpaRepository<Mark, Long> {
}
