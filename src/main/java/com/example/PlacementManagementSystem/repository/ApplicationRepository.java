package com.example.PlacementManagementSystem.repository;

import com.example.PlacementManagementSystem.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationRepository
        extends JpaRepository<Application, Long> {

    boolean existsByStudentIdAndJobId(
            Long studentId,
            Long jobId
    );

    Optional<Application> findByStudentIdAndJobId(
            Long studentId,
            Long jobId
    );
}