package com.example.PlacementManagementSystem.dto.job;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class JobRequestDTO {

    @NotBlank(message = "Job title is required")
    private String jobTitle;

    private String description;

    @NotNull(message = "Salary package is required")
    @DecimalMin(value = "0.0", message = "Salary package cannot be negative")
    private Double salaryPackage;

    @NotBlank(message = "Location is required")
    private String location;

    private String employmentType;

    @NotNull(message = "Minimum CGPA is required")
    @DecimalMin(value = "0.0", message = "Minimum CGPA cannot be less than 0")
    @DecimalMax(value = "10.0", message = "Minimum CGPA cannot be greater than 10")
    private Double minimumCgpa;

    @NotBlank(message = "Eligible branch is required")
    private String eligibleBranch;

    @NotNull(message = "Graduation year is required")
    private Integer graduationYear;

    @NotNull(message = "Company ID is required")
    private Long companyId;


    public JobRequestDTO() {
    }


    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Double getSalaryPackage() {
        return salaryPackage;
    }

    public void setSalaryPackage(Double salaryPackage) {
        this.salaryPackage = salaryPackage;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }


    public Double getMinimumCgpa() {
        return minimumCgpa;
    }

    public void setMinimumCgpa(Double minimumCgpa) {
        this.minimumCgpa = minimumCgpa;
    }


    public String getEligibleBranch() {
        return eligibleBranch;
    }

    public void setEligibleBranch(String eligibleBranch) {
        this.eligibleBranch = eligibleBranch;
    }


    public Integer getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(Integer graduationYear) {
        this.graduationYear = graduationYear;
    }


    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}