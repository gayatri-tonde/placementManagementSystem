package com.example.PlacementManagementSystem.service;

import com.example.PlacementManagementSystem.dto.placement.PlacementRequestDTO;
import com.example.PlacementManagementSystem.dto.placement.PlacementResponseDTO;
import com.example.PlacementManagementSystem.entity.Job;
import com.example.PlacementManagementSystem.entity.Placement;
import com.example.PlacementManagementSystem.entity.Student;
import com.example.PlacementManagementSystem.entity.Application;
import com.example.PlacementManagementSystem.entity.Interview;
import com.example.PlacementManagementSystem.enums.InterviewResult;
import com.example.PlacementManagementSystem.enums.PlacementStatus;
import com.example.PlacementManagementSystem.exception.PlacementNotFoundException;
import com.example.PlacementManagementSystem.exception.StudentNotFoundException;
import com.example.PlacementManagementSystem.exception.JobNotFoundException;
import com.example.PlacementManagementSystem.exception.StudentNotEligibleException;
import com.example.PlacementManagementSystem.repository.ApplicationRepository;
import com.example.PlacementManagementSystem.repository.InterviewRepository;
import com.example.PlacementManagementSystem.repository.JobRepository;
import com.example.PlacementManagementSystem.repository.PlacementRepository;
import com.example.PlacementManagementSystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PlacementService {

    private final PlacementRepository placementRepository;
    private final StudentRepository studentRepository;
    private final JobRepository jobRepository;
    private final ApplicationRepository applicationRepository;
    private final InterviewRepository interviewRepository;

    public PlacementService(
            PlacementRepository placementRepository,
            StudentRepository studentRepository,
            JobRepository jobRepository,
            ApplicationRepository applicationRepository,
            InterviewRepository interviewRepository) {

        this.placementRepository = placementRepository;
        this.studentRepository = studentRepository;
        this.jobRepository = jobRepository;
        this.applicationRepository = applicationRepository;
        this.interviewRepository = interviewRepository;
    }

    // =========================================================
    // CREATE PLACEMENT
    // =========================================================
    public PlacementResponseDTO createPlacement(
            PlacementRequestDTO request) {

        // CHECK STUDENT
        Student student = studentRepository.findById(
                request.getStudentId()
        ).orElseThrow(() ->
                new StudentNotFoundException(
                        "Student not found with ID: "
                                + request.getStudentId()
                ));

        // CHECK JOB
        Job job = jobRepository.findById(
                request.getJobId()
        ).orElseThrow(() ->
                new JobNotFoundException(
                        "Job not found with ID: "
                                + request.getJobId()
                ));

        // CHECK APPLICATION
        Application application = applicationRepository
                .findByStudentIdAndJobId(
                        student.getId(),
                        job.getId()
                )
                .orElseThrow(() ->
                        new StudentNotEligibleException(
                                "Student has not applied for this job"
                        ));

        // CHECK INTERVIEW
        Interview interview = interviewRepository
                .findByApplicationId(application.getId())
                .orElseThrow(() ->
                        new StudentNotEligibleException(
                                "Student has not completed an interview"
                        ));

        // CHECK INTERVIEW RESULT
        if (interview.getResult() != InterviewResult.PASSED) {

            throw new StudentNotEligibleException(
                    "Student must pass the interview before placement"
            );
        }

        // CHECK DUPLICATE PLACEMENT
        if (placementRepository.existsByStudentId(student.getId())) {

            throw new StudentNotEligibleException(
                    "Student is already placed"
            );
        }

        // CREATE PLACEMENT
        Placement placement = new Placement();

        placement.setStudent(student);
        placement.setJob(job);
        placement.setSalary(request.getSalary());
        placement.setPlacementDate(LocalDate.now());
        placement.setStatus(PlacementStatus.OFFERED);

        Placement savedPlacement =
                placementRepository.save(placement);

        return convertToResponse(savedPlacement);
    }

    // =========================================================
    // GET ALL PLACEMENTS
    // =========================================================
    public List<PlacementResponseDTO> getAllPlacements() {

        return placementRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    // =========================================================
    // GET PLACEMENT BY ID
    // =========================================================
    public PlacementResponseDTO getPlacementById(Long id) {

        Placement placement =
                placementRepository.findById(id)
                        .orElseThrow(() ->
                                new PlacementNotFoundException(
                                        "Placement not found with ID: "
                                                + id
                                ));

        return convertToResponse(placement);
    }

    // =========================================================
    // UPDATE PLACEMENT STATUS
    // =========================================================
    public PlacementResponseDTO updatePlacementStatus(
            Long id,
            PlacementStatus status) {

        Placement placement =
                placementRepository.findById(id)
                        .orElseThrow(() ->
                                new PlacementNotFoundException(
                                        "Placement not found with ID: "
                                                + id
                                ));

        placement.setStatus(status);

        Placement updatedPlacement =
                placementRepository.save(placement);

        return convertToResponse(updatedPlacement);
    }

    // =========================================================
    // DELETE PLACEMENT
    // =========================================================
    public void deletePlacement(Long id) {

        Placement placement =
                placementRepository.findById(id)
                        .orElseThrow(() ->
                                new PlacementNotFoundException(
                                        "Placement not found with ID: "
                                                + id
                                ));

        placementRepository.delete(placement);
    }

    // =========================================================
    // ENTITY → RESPONSE DTO
    // =========================================================
    private PlacementResponseDTO convertToResponse(
            Placement placement) {

        return new PlacementResponseDTO(
                placement.getId(),

                placement.getStudent().getId(),
                placement.getStudent().getName(),

                placement.getJob().getId(),
                placement.getJob().getJobTitle(),

                placement.getJob().getCompany().getName(),

                placement.getSalary(),
                placement.getPlacementDate(),
                placement.getStatus()
        );
    }
}