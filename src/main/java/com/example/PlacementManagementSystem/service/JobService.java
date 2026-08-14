package com.example.PlacementManagementSystem.service;

import com.example.PlacementManagementSystem.dto.job.JobRequestDTO;
import com.example.PlacementManagementSystem.dto.job.JobResponseDTO;
import com.example.PlacementManagementSystem.entity.Company;
import com.example.PlacementManagementSystem.entity.Job;
import com.example.PlacementManagementSystem.exception.CompanyNotFoundException;
import com.example.PlacementManagementSystem.exception.JobNotFoundException;
import com.example.PlacementManagementSystem.repository.CompanyRepository;
import com.example.PlacementManagementSystem.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    private final JobRepository jobRepository;
    private final CompanyRepository companyRepository;

    public JobService(JobRepository jobRepository,
                      CompanyRepository companyRepository) {
        this.jobRepository = jobRepository;
        this.companyRepository = companyRepository;
    }


    // CREATE
    public JobResponseDTO createJob(JobRequestDTO request) {

        Company company = companyRepository.findById(request.getCompanyId())
                .orElseThrow(() ->
                        new CompanyNotFoundException(
                                "Company not found with ID: "
                                        + request.getCompanyId()));

        Job job = new Job();

        job.setJobTitle(request.getJobTitle());
        job.setDescription(request.getDescription());
        job.setSalaryPackage(request.getSalaryPackage());
        job.setLocation(request.getLocation());
        job.setEmploymentType(request.getEmploymentType());
        job.setMinimumCgpa(request.getMinimumCgpa());
        job.setEligibleBranch(request.getEligibleBranch());
        job.setGraduationYear(request.getGraduationYear());
        job.setCompany(company);

        Job savedJob = jobRepository.save(job);

        return convertToResponse(savedJob);
    }


    // GET ALL
    public List<JobResponseDTO> getAllJobs() {

        return jobRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .toList();
    }


    // GET BY ID
    public JobResponseDTO getJobById(Long id) {

        Job job = jobRepository.findById(id)
                .orElseThrow(() ->
                        new JobNotFoundException(
                                "Job not found with ID: " + id));

        return convertToResponse(job);
    }


    // UPDATE
    public JobResponseDTO updateJob(Long id, JobRequestDTO request) {

        Job job = jobRepository.findById(id)
                .orElseThrow(() ->
                        new JobNotFoundException(
                                "Job not found with ID: " + id));

        Company company = companyRepository.findById(request.getCompanyId())
                .orElseThrow(() ->
                        new CompanyNotFoundException(
                                "Company not found with ID: "
                                        + request.getCompanyId()));

        job.setJobTitle(request.getJobTitle());
        job.setDescription(request.getDescription());
        job.setSalaryPackage(request.getSalaryPackage());
        job.setLocation(request.getLocation());
        job.setEmploymentType(request.getEmploymentType());
        job.setMinimumCgpa(request.getMinimumCgpa());
        job.setEligibleBranch(request.getEligibleBranch());
        job.setGraduationYear(request.getGraduationYear());
        job.setCompany(company);

        Job updatedJob = jobRepository.save(job);

        return convertToResponse(updatedJob);
    }


    // DEACTIVATE
    public JobResponseDTO deactivateJob(Long id) {

        Job job = jobRepository.findById(id)
                .orElseThrow(() ->
                        new JobNotFoundException(
                                "Job not found with ID: " + id));

        job.setActive(false);

        Job updatedJob = jobRepository.save(job);

        return convertToResponse(updatedJob);
    }


    // ENTITY → RESPONSE DTO
    private JobResponseDTO convertToResponse(Job job) {

        return new JobResponseDTO(
                job.getId(),
                job.getJobTitle(),
                job.getDescription(),
                job.getSalaryPackage(),
                job.getLocation(),
                job.getEmploymentType(),
                job.getMinimumCgpa(),
                job.getEligibleBranch(),
                job.getGraduationYear(),
                job.getActive(),
                job.getCompany().getId(),
                job.getCompany().getName()
        );
    }
}