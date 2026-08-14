package com.example.PlacementManagementSystem.dto.company;

public class CompanyResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String industry;
    private String location;
    private String website;
    private String description;
    private Boolean active;

    public CompanyResponseDTO() {
    }

    public CompanyResponseDTO(Long id, String name, String email,
                              String industry, String location,
                              String website, String description,
                              Boolean active) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.industry = industry;
        this.location = location;
        this.website = website;
        this.description = description;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}