package com.example.PlacementManagementSystem.repository;

import com.example.PlacementManagementSystem.entity.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InterviewRepository
        extends JpaRepository<Interview, Long> {

    boolean existsByApplicationId(Long applicationId);

    Optional<Interview> findByApplicationId(Long applicationId);
}