package com.example.PlacementManagementSystem.repository;

import com.example.PlacementManagementSystem.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

    List<Job> findByActiveTrue();

    List<Job> findByCompanyId(Long companyId);

    List<Job> findByEligibleBranchIgnoreCase(String branch);

    List<Job> findByGraduationYear(Integer graduationYear);
}