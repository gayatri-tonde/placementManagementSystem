package com.example.PlacementManagementSystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String jobTitle;

    private String description;

    private Double salaryPackage;

    private String location;

    private String employmentType;

    private Double minimumCgpa;

    private String eligibleBranch;

    private Integer graduationYear;

    private Boolean active = true;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;


    public Job() {
    }


    public Job(String jobTitle, String description,
               Double salaryPackage, String location,
               String employmentType, Double minimumCgpa,
               String eligibleBranch, Integer graduationYear,
               Company company) {

        this.jobTitle = jobTitle;
        this.description = description;
        this.salaryPackage = salaryPackage;
        this.location = location;
        this.employmentType = employmentType;
        this.minimumCgpa = minimumCgpa;
        this.eligibleBranch = eligibleBranch;
        this.graduationYear = graduationYear;
        this.company = company;
        this.active = true;
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


    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}