package com.example.PlacementManagementSystem.controller;

import com.example.PlacementManagementSystem.dto.application.ApplicationRequestDTO;
import com.example.PlacementManagementSystem.dto.application.ApplicationResponseDTO;
import com.example.PlacementManagementSystem.enums.ApplicationStatus;
import com.example.PlacementManagementSystem.service.ApplicationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(
            ApplicationService applicationService) {

        this.applicationService = applicationService;
    }

    // APPLY FOR JOB
    @PostMapping
    public ResponseEntity<ApplicationResponseDTO> applyForJob(
            @Valid @RequestBody ApplicationRequestDTO request) {

        return new ResponseEntity<>(
                applicationService.applyForJob(request),
                HttpStatus.CREATED
        );
    }

    // GET ALL APPLICATIONS
    @GetMapping
    public ResponseEntity<List<ApplicationResponseDTO>>
    getAllApplications() {

        return ResponseEntity.ok(
                applicationService.getAllApplications()
        );
    }

    // GET APPLICATION BY ID
    @GetMapping("/{id}")
    public ResponseEntity<ApplicationResponseDTO>
    getApplicationById(@PathVariable Long id) {

        return ResponseEntity.ok(
                applicationService.getApplicationById(id)
        );
    }

    // UPDATE APPLICATION STATUS
    @PutMapping("/{id}/status")
    public ResponseEntity<ApplicationResponseDTO>
    updateApplicationStatus(
            @PathVariable Long id,
            @RequestParam ApplicationStatus status) {

        return ResponseEntity.ok(
                applicationService.updateApplicationStatus(
                        id,
                        status
                )
        );
    }
}