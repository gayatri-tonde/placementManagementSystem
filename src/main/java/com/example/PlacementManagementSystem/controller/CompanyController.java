package com.example.PlacementManagementSystem.controller;

import com.example.PlacementManagementSystem.dto.company.CompanyRequestDTO;
import com.example.PlacementManagementSystem.dto.company.CompanyResponseDTO;
import com.example.PlacementManagementSystem.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<CompanyResponseDTO> createCompany(
            @Valid @RequestBody CompanyRequestDTO request) {

        return new ResponseEntity<>(
                companyService.createCompany(request),
                HttpStatus.CREATED
        );
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<CompanyResponseDTO>> getAllCompanies() {

        return ResponseEntity.ok(
                companyService.getAllCompanies()
        );
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<CompanyResponseDTO> getCompanyById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                companyService.getCompanyById(id)
        );
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<CompanyResponseDTO> updateCompany(
            @PathVariable Long id,
            @Valid @RequestBody CompanyRequestDTO request) {

        return ResponseEntity.ok(
                companyService.updateCompany(id, request)
        );
    }

    // DEACTIVATE
    @PutMapping("/{id}/deactivate")
    public ResponseEntity<CompanyResponseDTO> deactivateCompany(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                companyService.deactivateCompany(id)
        );
    }
}