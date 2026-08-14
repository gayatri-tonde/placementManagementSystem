package com.example.PlacementManagementSystem.service;

import com.example.PlacementManagementSystem.dto.application.ApplicationRequestDTO;
import com.example.PlacementManagementSystem.dto.application.ApplicationResponseDTO;
import com.example.PlacementManagementSystem.entity.Application;
import com.example.PlacementManagementSystem.entity.Job;
import com.example.PlacementManagementSystem.entity.Student;
import com.example.PlacementManagementSystem.enums.ApplicationStatus;
import com.example.PlacementManagementSystem.exception.ApplicationNotFoundException;
import com.example.PlacementManagementSystem.exception.DuplicateApplicationException;
import com.example.PlacementManagementSystem.exception.StudentNotEligibleException;
import com.example.PlacementManagementSystem.exception.StudentNotFoundException;
import com.example.PlacementManagementSystem.exception.JobNotFoundException;
import com.example.PlacementManagementSystem.repository.ApplicationRepository;
import com.example.PlacementManagementSystem.repository.JobRepository;
import com.example.PlacementManagementSystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final StudentRepository studentRepository;
    private final JobRepository jobRepository;

    public ApplicationService(
            ApplicationRepository applicationRepository,
            StudentRepository studentRepository,
            JobRepository jobRepository) {

        this.applicationRepository = applicationRepository;
        this.studentRepository = studentRepository;
        this.jobRepository = jobRepository;
    }

    // APPLY FOR JOB
    public ApplicationResponseDTO applyForJob(
            ApplicationRequestDTO request) {

        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() ->
                        new StudentNotFoundException(
                                "Student not found with ID: "
                                        + request.getStudentId()));

        Job job = jobRepository.findById(request.getJobId())
                .orElseThrow(() ->
                        new JobNotFoundException(
                                "Job not found with ID: "
                                        + request.getJobId()));

        // CHECK IF JOB IS ACTIVE
        if (!Boolean.TRUE.equals(job.getActive())) {
            throw new StudentNotEligibleException(
                    "This job is no longer active");
        }

        // CHECK DUPLICATE APPLICATION
        if (applicationRepository.existsByStudentIdAndJobId(
                student.getId(),
                job.getId())) {

            throw new DuplicateApplicationException(
                    "Student has already applied for this job");
        }

        // CHECK CGPA
        if (student.getCgpa() < job.getMinimumCgpa()) {

            throw new StudentNotEligibleException(
                    "Student is not eligible. Minimum CGPA required: "
                            + job.getMinimumCgpa());
        }

        // CHECK BRANCH
        if (!student.getBranch()
                .equalsIgnoreCase(job.getEligibleBranch())) {

            throw new StudentNotEligibleException(
                    "Student branch is not eligible for this job");
        }

        // CHECK GRADUATION YEAR
        if (!student.getGraduationYear()
                .equals(job.getGraduationYear())) {

            throw new StudentNotEligibleException(
                    "Student graduation year is not eligible");
        }

        // CREATE APPLICATION
        Application application =
                new Application(student, job);

        application.setRemarks(request.getRemarks());

        Application savedApplication =
                applicationRepository.save(application);

        return convertToResponse(savedApplication);
    }

    // GET ALL APPLICATIONS
    public List<ApplicationResponseDTO> getAllApplications() {

        return applicationRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    // GET APPLICATION BY ID
    public ApplicationResponseDTO getApplicationById(Long id) {

        Application application =
                applicationRepository.findById(id)
                        .orElseThrow(() ->
                                new ApplicationNotFoundException(
                                        "Application not found with ID: "
                                                + id));

        return convertToResponse(application);
    }

    // UPDATE APPLICATION STATUS
    public ApplicationResponseDTO updateApplicationStatus(
            Long id,
            ApplicationStatus status) {

        Application application =
                applicationRepository.findById(id)
                        .orElseThrow(() ->
                                new ApplicationNotFoundException(
                                        "Application not found with ID: "
                                                + id));

        application.setStatus(status);

        Application updatedApplication =
                applicationRepository.save(application);

        return convertToResponse(updatedApplication);
    }

    // ENTITY → RESPONSE DTO
    private ApplicationResponseDTO convertToResponse(
            Application application) {

        return new ApplicationResponseDTO(
                application.getId(),

                application.getStudent().getId(),
                application.getStudent().getName(),

                application.getJob().getId(),
                application.getJob().getJobTitle(),

                application.getJob().getCompany().getName(),

                application.getAppliedAt(),
                application.getStatus(),
                application.getRemarks()
        );
    }
}