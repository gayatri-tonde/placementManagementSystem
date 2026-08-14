package com.example.PlacementManagementSystem.service;

import com.example.PlacementManagementSystem.dto.company.CompanyRequestDTO;
import com.example.PlacementManagementSystem.dto.company.CompanyResponseDTO;
import com.example.PlacementManagementSystem.entity.Company;
import com.example.PlacementManagementSystem.exception.CompanyNotFoundException;
import com.example.PlacementManagementSystem.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    // CREATE
    public CompanyResponseDTO createCompany(CompanyRequestDTO request) {

        Company company = new Company();

        company.setName(request.getName());
        company.setEmail(request.getEmail());
        company.setIndustry(request.getIndustry());
        company.setLocation(request.getLocation());
        company.setWebsite(request.getWebsite());
        company.setDescription(request.getDescription());

        Company savedCompany = companyRepository.save(company);

        return convertToResponse(savedCompany);
    }

    // GET ALL
    public List<CompanyResponseDTO> getAllCompanies() {

        return companyRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    // GET BY ID
    public CompanyResponseDTO getCompanyById(Long id) {

        Company company = companyRepository.findById(id)
                .orElseThrow(() ->
                        new CompanyNotFoundException(
                                "Company not found with ID: " + id));

        return convertToResponse(company);
    }

    // UPDATE
    public CompanyResponseDTO updateCompany(
            Long id, CompanyRequestDTO request) {

        Company company = companyRepository.findById(id)
                .orElseThrow(() ->
                        new CompanyNotFoundException(
                                "Company not found with ID: " + id));

        company.setName(request.getName());
        company.setEmail(request.getEmail());
        company.setIndustry(request.getIndustry());
        company.setLocation(request.getLocation());
        company.setWebsite(request.getWebsite());
        company.setDescription(request.getDescription());

        Company updatedCompany = companyRepository.save(company);

        return convertToResponse(updatedCompany);
    }

    // DEACTIVATE
    public CompanyResponseDTO deactivateCompany(Long id) {

        Company company = companyRepository.findById(id)
                .orElseThrow(() ->
                        new CompanyNotFoundException(
                                "Company not found with ID: " + id));

        company.setActive(false);

        Company updatedCompany = companyRepository.save(company);

        return convertToResponse(updatedCompany);
    }

    // ENTITY → RESPONSE DTO
    private CompanyResponseDTO convertToResponse(Company company) {

        return new CompanyResponseDTO(
                company.getId(),
                company.getName(),
                company.getEmail(),
                company.getIndustry(),
                company.getLocation(),
                company.getWebsite(),
                company.getDescription(),
                company.getActive()
        );
    }
}