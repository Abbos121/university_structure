package com.self.university_structure.repository;

import com.self.university_structure.entity.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface JournalRepository  extends JpaRepository<Journal, Long> {

    @Query(value = "SELECT * FROM JOURNAL WHERE ID IN :ids", nativeQuery = true)
    List<Journal> findAllByIdSet(@Param("ids") Set<Long> ids);
}
