package com.example.PlacementManagementSystem.dto.application;

import com.example.PlacementManagementSystem.enums.ApplicationStatus;

import java.time.LocalDateTime;

public class ApplicationResponseDTO {

    private Long id;

    private Long studentId;
    private String studentName;

    private Long jobId;
    private String jobTitle;

    private String companyName;

    private LocalDateTime appliedAt;

    private ApplicationStatus status;

    private String remarks;

    public ApplicationResponseDTO() {
    }

    public ApplicationResponseDTO(
            Long id,
            Long studentId,
            String studentName,
            Long jobId,
            String jobTitle,
            String companyName,
            LocalDateTime appliedAt,
            ApplicationStatus status,
            String remarks) {

        this.id = id;
        this.studentId = studentId;
        this.studentName = studentName;
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.companyName = companyName;
        this.appliedAt = appliedAt;
        this.status = status;
        this.remarks = remarks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
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

    public LocalDateTime getAppliedAt() {
        return appliedAt;
    }

    public void setAppliedAt(LocalDateTime appliedAt) {
        this.appliedAt = appliedAt;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}