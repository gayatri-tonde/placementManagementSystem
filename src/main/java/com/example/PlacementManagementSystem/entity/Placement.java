package com.example.PlacementManagementSystem.entity;

import com.example.PlacementManagementSystem.enums.PlacementStatus;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "placements")
public class Placement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(
            name = "student_id",
            nullable = false,
            unique = true
    )
    private Student student;

    @OneToOne
    @JoinColumn(
            name = "job_id",
            nullable = false
    )
    private Job job;

    @Column(nullable = false)
    private Double salary;

    private LocalDate placementDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PlacementStatus status;

    public Placement() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
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