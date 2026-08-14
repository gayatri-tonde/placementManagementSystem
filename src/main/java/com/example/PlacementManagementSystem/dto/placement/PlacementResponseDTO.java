package com.example.PlacementManagementSystem.dto.placement;

import com.example.PlacementManagementSystem.enums.PlacementStatus;

import java.time.LocalDate;

public class PlacementResponseDTO {

    private Long id;

    private Long studentId;
    private String studentName;

    private Long jobId;
    private String jobTitle;

    private String companyName;

    private Double salary;

    private LocalDate placementDate;

    private PlacementStatus status;

    public PlacementResponseDTO() {
    }

    public PlacementResponseDTO(
            Long id,
            Long studentId,
            String studentName,
            Long jobId,
            String jobTitle,
            String companyName,
            Double salary,
            LocalDate placementDate,
            PlacementStatus status) {

        this.id = id;
        this.studentId = studentId;
        this.studentName = studentName;
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.companyName = companyName;
        this.salary = salary;
        this.placementDate = placementDate;
        this.status = status;
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public LocalDate getPlacementDate() {
        return placementDate;
    }

    public void setPlacementDate(LocalDate placementDate) {
        this.placementDate = placementDate;
    }

    public PlacementStatus getStatus() {
        return status;
    }

    public void setStatus(PlacementStatus status) {
        this.status = status;
    }
}