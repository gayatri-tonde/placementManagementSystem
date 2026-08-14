package com.example.PlacementManagementSystem.controller;

import com.example.PlacementManagementSystem.dto.interview.InterviewRequestDTO;
import com.example.PlacementManagementSystem.dto.interview.InterviewResponseDTO;
import com.example.PlacementManagementSystem.enums.InterviewResult;
import com.example.PlacementManagementSystem.service.InterviewService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interviews")
public class InterviewController {

    private final InterviewService interviewService;

    public InterviewController(
            InterviewService interviewService) {

        this.interviewService = interviewService;
    }

    // SCHEDULE INTERVIEW
    @PostMapping
    public ResponseEntity<InterviewResponseDTO> scheduleInterview(
            @Valid @RequestBody InterviewRequestDTO request) {

        return new ResponseEntity<>(
                interviewService.scheduleInterview(request),
                HttpStatus.CREATED
        );
    }

    // GET ALL INTERVIEWS
    @GetMapping
    public ResponseEntity<List<InterviewResponseDTO>>
    getAllInterviews() {

        return ResponseEntity.ok(
                interviewService.getAllInterviews()
        );
    }

    // GET INTERVIEW BY ID
    @GetMapping("/{id}")
    public ResponseEntity<InterviewResponseDTO>
    getInterviewById(@PathVariable Long id) {

        return ResponseEntity.ok(
                interviewService.getInterviewById(id)
        );
    }

    // UPDATE INTERVIEW RESULT
    @PutMapping("/{id}/result")
    public ResponseEntity<InterviewResponseDTO>
    updateInterviewResult(
            @PathVariable Long id,
            @RequestParam InterviewResult result) {

        return ResponseEntity.ok(
                interviewService.updateInterviewResult(
                        id,
                        result
                )
        );
    }

    // UPDATE INTERVIEW FEEDBACK
    @PutMapping("/{id}/feedback")
    public ResponseEntity<InterviewResponseDTO>
    updateFeedback(
            @PathVariable Long id,
            @RequestParam String feedback) {

        return ResponseEntity.ok(
                interviewService.updateFeedback(
                        id,
                        feedback
                )
        );
    }
}