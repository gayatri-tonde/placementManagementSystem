package com.example.PlacementManagementSystem.service;

import com.example.PlacementManagementSystem.repository.ApplicationRepository;
import com.example.PlacementManagementSystem.repository.CompanyRepository;
import com.example.PlacementManagementSystem.repository.InterviewRepository;
import com.example.PlacementManagementSystem.repository.JobRepository;
import com.example.PlacementManagementSystem.repository.PlacementRepository;
import com.example.PlacementManagementSystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class DashboardService {

    private final StudentRepository studentRepository;
    private final CompanyRepository companyRepository;
    private final JobRepository jobRepository;
    private final ApplicationRepository applicationRepository;
    private final InterviewRepository interviewRepository;
    private final PlacementRepository placementRepository;

    public DashboardService(
            StudentRepository studentRepository,
            CompanyRepository companyRepository,
            JobRepository jobRepository,
            ApplicationRepository applicationRepository,
            InterviewRepository interviewRepository,
            PlacementRepository placementRepository) {

        this.studentRepository = studentRepository;
        this.companyRepository = companyRepository;
        this.jobRepository = jobRepository;
        this.applicationRepository = applicationRepository;
        this.interviewRepository = interviewRepository;
        this.placementRepository = placementRepository;
    }

    public Map<String, Long> getDashboardSummary() {

        Map<String, Long> summary = new LinkedHashMap<>();

        summary.put("totalStudents",
                studentRepository.count());

        summary.put("totalCompanies",
                companyRepository.count());

        summary.put("totalJobs",
                jobRepository.count());

        summary.put("totalApplications",
                applicationRepository.count());

        summary.put("totalInterviews",
                interviewRepository.count());

        summary.put("totalPlacements",
                placementRepository.count());

        return summary;
    }
}