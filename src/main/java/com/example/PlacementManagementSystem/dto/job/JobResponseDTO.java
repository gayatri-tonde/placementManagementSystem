package com.example.PlacementManagementSystem.dto.job;

public class JobResponseDTO {

    private Long id;
    private String jobTitle;
    private String description;
    private Double salaryPackage;
    private String location;
    private String employmentType;
    private Double minimumCgpa;
    private String eligibleBranch;
    private Integer graduationYear;
    private Boolean active;

    private Long companyId;
    private String companyName;


    public JobResponseDTO() {
    }


    public JobResponseDTO(Long id, String jobTitle, String description,
                          Double salaryPackage, String location,
                          String employmentType, Double minimumCgpa,
                          String eligibleBranch, Integer graduationYear,
                          Boolean active, Long companyId,
                          String companyName) {

        this.id = id;
        this.jobTitle = jobTitle;
        this.description = description;
        this.salaryPackage = salaryPackage;
        this.location = location;
        this.employmentType = employmentType;
        this.minimumCgpa = minimumCgpa;
        this.eligibleBranch = eligibleBranch;
        this.graduationYear = graduationYear;
        this.active = active;
        this.companyId = companyId;
        this.companyName = companyName;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }


    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}