package com.example.PlacementManagementSystem.controller;

import com.example.PlacementManagementSystem.dto.job.JobRequestDTO;
import com.example.PlacementManagementSystem.dto.job.JobResponseDTO;
import com.example.PlacementManagementSystem.service.JobService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }


    // CREATE
    @PostMapping
    public ResponseEntity<JobResponseDTO> createJob(
            @Valid @RequestBody JobRequestDTO request) {

        return new ResponseEntity<>(
                jobService.createJob(request),
                HttpStatus.CREATED
        );
    }


    // GET ALL
    @GetMapping
    public ResponseEntity<List<JobResponseDTO>> getAllJobs() {

        return ResponseEntity.ok(
                jobService.getAllJobs()
        );
    }


    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<JobResponseDTO> getJobById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                jobService.getJobById(id)
        );
    }


    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<JobResponseDTO> updateJob(
            @PathVariable Long id,
            @Valid @RequestBody JobRequestDTO request) {

        return ResponseEntity.ok(
                jobService.updateJob(id, request)
        );
    }


    // DEACTIVATE
    @PutMapping("/{id}/deactivate")
    public ResponseEntity<JobResponseDTO> deactivateJob(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                jobService.deactivateJob(id)
        );
    }
}