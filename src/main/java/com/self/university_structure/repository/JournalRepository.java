package com.self.university_structure.repository;

import com.self.university_structure.entity.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalRepository  extends JpaRepository<Journal, Long> {
}
