package com.self.university_structure.repository;

import com.self.university_structure.entity.Student;
import com.self.university_structure.repository.custom.StudentCustomRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>, StudentCustomRepo {
}
