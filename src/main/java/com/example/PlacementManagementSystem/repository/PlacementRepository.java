package com.example.PlacementManagementSystem.repository;

import com.example.PlacementManagementSystem.entity.Placement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlacementRepository
        extends JpaRepository<Placement, Long> {

    boolean existsByStudentId(Long studentId);
}