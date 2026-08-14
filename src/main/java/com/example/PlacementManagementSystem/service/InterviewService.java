package com.example.PlacementManagementSystem.service;

import com.example.PlacementManagementSystem.dto.interview.InterviewRequestDTO;
import com.example.PlacementManagementSystem.dto.interview.InterviewResponseDTO;
import com.example.PlacementManagementSystem.entity.Application;
import com.example.PlacementManagementSystem.entity.Interview;
import com.example.PlacementManagementSystem.enums.InterviewResult;
import com.example.PlacementManagementSystem.exception.ApplicationNotFoundException;
import com.example.PlacementManagementSystem.exception.DuplicateApplicationException;
import com.example.PlacementManagementSystem.exception.InterviewNotFoundException;
import com.example.PlacementManagementSystem.repository.ApplicationRepository;
import com.example.PlacementManagementSystem.repository.InterviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewService {

    private final InterviewRepository interviewRepository;
    private final ApplicationRepository applicationRepository;

    public InterviewService(
            InterviewRepository interviewRepository,
            ApplicationRepository applicationRepository) {

        this.interviewRepository = interviewRepository;
        this.applicationRepository = applicationRepository;
    }

    // SCHEDULE INTERVIEW
    public InterviewResponseDTO scheduleInterview(
            InterviewRequestDTO request) {

        Application application =
                applicationRepository.findById(request.getApplicationId())
                        .orElseThrow(() ->
                                new ApplicationNotFoundException(
                                        "Application not found with ID: "
                                                + request.getApplicationId()));

        // CHECK IF INTERVIEW ALREADY EXISTS
        if (interviewRepository.existsByApplicationId(
                application.getId())) {

            throw new DuplicateApplicationException(
                    "An interview is already scheduled for this application");
        }

        Interview interview = new Interview();

        interview.setApplication(application);
        interview.setInterviewDate(request.getInterviewDate());
        interview.setInterviewer(request.getInterviewer());
        interview.setFeedback(request.getFeedback());

        // Initial result
        interview.setResult(InterviewResult.SCHEDULED);

        Interview savedInterview =
                interviewRepository.save(interview);

        return convertToResponse(savedInterview);
    }

    // GET ALL INTERVIEWS
    public List<InterviewResponseDTO> getAllInterviews() {

        return interviewRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    // GET INTERVIEW BY ID
    public InterviewResponseDTO getInterviewById(Long id) {

        Interview interview =
                interviewRepository.findById(id)
                        .orElseThrow(() ->
                                new InterviewNotFoundException(
                                        "Interview not found with ID: "
                                                + id));

        return convertToResponse(interview);
    }

    // UPDATE INTERVIEW RESULT
    public InterviewResponseDTO updateInterviewResult(
            Long id,
            InterviewResult result) {

        Interview interview =
                interviewRepository.findById(id)
                        .orElseThrow(() ->
                                new InterviewNotFoundException(
                                        "Interview not found with ID: "
                                                + id));

        interview.setResult(result);

        Interview updatedInterview =
                interviewRepository.save(interview);

        return convertToResponse(updatedInterview);
    }

    // UPDATE INTERVIEW FEEDBACK
    public InterviewResponseDTO updateFeedback(
            Long id,
            String feedback) {

        Interview interview =
                interviewRepository.findById(id)
                        .orElseThrow(() ->
                                new InterviewNotFoundException(
                                        "Interview not found with ID: "
                                                + id));

        interview.setFeedback(feedback);

        Interview updatedInterview =
                interviewRepository.save(interview);

        return convertToResponse(updatedInterview);
    }

    // ENTITY → RESPONSE DTO
    private InterviewResponseDTO convertToResponse(
            Interview interview) {

        return new InterviewResponseDTO(
                interview.getId(),

                interview.getApplication().getId(),

                interview.getApplication()
                        .getStudent()
                        .getName(),

                interview.getApplication()
                        .getJob()
                        .getJobTitle(),

                interview.getApplication()
                        .getJob()
                        .getCompany()
                        .getName(),

                interview.getInterviewDate(),

                interview.getInterviewer(),

                interview.getFeedback(),

                interview.getResult()
        );
    }
}