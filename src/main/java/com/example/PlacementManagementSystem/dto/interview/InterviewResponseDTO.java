package com.example.PlacementManagementSystem.dto.interview;

import com.example.PlacementManagementSystem.enums.InterviewResult;

import java.time.LocalDateTime;

public class InterviewResponseDTO {

    private Long id;

    private Long applicationId;

    private String studentName;

    private String jobTitle;

    private String companyName;

    private LocalDateTime interviewDate;

    private String interviewer;

    private String feedback;

    private InterviewResult result;

    public InterviewResponseDTO() {
    }

    public InterviewResponseDTO(
            Long id,
            Long applicationId,
            String studentName,
            String jobTitle,
            String companyName,
            LocalDateTime interviewDate,
            String interviewer,
            String feedback,
            InterviewResult result) {

        this.id = id;
        this.applicationId = applicationId;
        this.studentName = studentName;
        this.jobTitle = jobTitle;
        this.companyName = companyName;
        this.interviewDate = interviewDate;
        this.interviewer = interviewer;
        this.feedback = feedback;
        this.result = result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public InterviewResult getResult() {
        return result;
    }

    public void setResult(InterviewResult result) {
        this.result = result;
    }
}