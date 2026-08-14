package com.example.PlacementManagementSystem.dto.interview;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class InterviewRequestDTO {

    @NotNull(message = "Application ID is required")
    private Long applicationId;

    @NotNull(message = "Interview date is required")
    private LocalDateTime interviewDate;

    private String interviewer;

    private String feedback;

    public InterviewRequestDTO() {
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public LocalDateTime getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(LocalDateTime interviewDate) {
        this.interviewDate = interviewDate;
    }

    public String getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(String interviewer) {
        this.interviewer = interviewer;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}