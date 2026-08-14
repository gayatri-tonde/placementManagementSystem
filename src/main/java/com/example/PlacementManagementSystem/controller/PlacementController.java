package com.example.PlacementManagementSystem.controller;

import com.example.PlacementManagementSystem.dto.placement.PlacementRequestDTO;
import com.example.PlacementManagementSystem.dto.placement.PlacementResponseDTO;
import com.example.PlacementManagementSystem.enums.PlacementStatus;
import com.example.PlacementManagementSystem.service.PlacementService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/placements")
public class PlacementController {

    private final PlacementService placementService;

    public PlacementController(PlacementService placementService) {
        this.placementService = placementService;
    }

    // CREATE PLACEMENT
    @PostMapping
    public ResponseEntity<PlacementResponseDTO> createPlacement(
            @Valid @RequestBody PlacementRequestDTO request) {

        return new ResponseEntity<>(
                placementService.createPlacement(request),
                HttpStatus.CREATED
        );
    }

    // GET ALL PLACEMENTS
    @GetMapping
    public ResponseEntity<List<PlacementResponseDTO>> getAllPlacements() {

        return ResponseEntity.ok(
                placementService.getAllPlacements()
        );
    }

    // GET PLACEMENT BY ID
    @GetMapping("/{id}")
    public ResponseEntity<PlacementResponseDTO> getPlacementById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                placementService.getPlacementById(id)
        );
    }

    // UPDATE PLACEMENT STATUS
    @PutMapping("/{id}/status")
    public ResponseEntity<PlacementResponseDTO> updatePlacementStatus(
            @PathVariable Long id,
            @RequestParam PlacementStatus status) {

        return ResponseEntity.ok(
                placementService.updatePlacementStatus(
                        id,
                        status
                )
        );
    }

    // DELETE PLACEMENT
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlacement(
            @PathVariable Long id) {

        placementService.deletePlacement(id);

        return ResponseEntity.noContent().build();
    }
}