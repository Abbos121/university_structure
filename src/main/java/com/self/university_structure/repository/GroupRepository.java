package com.self.university_structure.repository;

import com.self.university_structure.entity.Group;
import com.self.university_structure.repository.custom.GroupCustomRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository  extends JpaRepository<Group, Long>, GroupCustomRepo {
}
