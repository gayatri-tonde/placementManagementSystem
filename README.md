# Placement Management System 🎓

A Spring Boot REST API for managing student profiles, companies, job opportunities, job applications, interviews, and placement records using Java, Spring Boot, Spring Data JPA, Hibernate, Maven, and MySQL.

## Overview

The Placement Management System organizes campus recruitment activities through REST APIs. It supports maintaining student and company information, publishing jobs, processing applications, scheduling interviews, recording interview outcomes, and tracking placement status.

The application follows a controller–service–repository structure. Request and response DTOs handle API data, while JPA entities represent persistent records.

## Features

### Student Management
- Create, retrieve, update, and delete student records.
- Deactivate student records.
- Add skills to student profiles.
- Validate supported requests using DTOs.

### Company and Job Management
- Create, retrieve, and update company information.
- Deactivate companies.
- Create, retrieve, and update job postings.
- Deactivate job postings.

### Job Applications
- Submit job applications.
- Retrieve applications by ID or list all applications.
- Update application status.
- Apply business rules such as duplicate-application and eligibility checks where implemented.

### Interview Management
- Schedule interviews.
- Retrieve interview records.
- Update interview results and feedback.

### Placement Tracking and Dashboard
- Create and retrieve placement records.
- Update placement status and delete placement records.
- Retrieve dashboard summary counts.

### API and Error Handling
- REST APIs built with Spring Web.
- Database access through Spring Data JPA.
- Request validation using Jakarta Bean Validation.
- Custom exceptions for missing resources, duplicate records, and eligibility failures.
- Centralized exception handling.

## Technology Stack

| Technology | Purpose |
|---|---|
| Java 17 | Programming language |
| Spring Boot 3.5.4 | Application framework |
| Spring Web | REST API development |
| Spring Data JPA | Persistence and repository layer |
| Hibernate | ORM implementation |
| MySQL | Relational database |
| MySQL Connector/J | Database connectivity |
| Jakarta Bean Validation | Request validation |
| Maven | Build and dependency management |
| Spring Boot Starter Test | Testing support |

## Application Architecture

The application separates request handling, business logic, persistence, and database models.

1. Controllers handle HTTP requests and responses.
2. DTOs define request and response payloads.
3. Services implement business logic.
4. Repositories manage database operations.
5. Entities represent students, companies, jobs, applications, interviews, placements, and skills.
6. MySQL stores application data.

### Request Flow

Client → REST Controller → DTO → Service → Repository → MySQL

## Project Structure

```text
placementManagementSystem/
├── Database/
│   └── placement_management.sql
├── mvnw
├── mvnw.cmd
├── pom.xml
└── src/
    ├── main/
    │   ├── java/com/example/PlacementManagementSystem/
    │   │   ├── controller/
    │   │   ├── dto/
    │   │   ├── entity/
    │   │   ├── enums/
    │   │   ├── exception/
    │   │   ├── repository/
    │   │   ├── service/
    │   │   └── PlacementManagementSystemApplication.java
    │   └── resources/
    │       └── application.properties
    └── test/
```

## Main API Endpoints

| Module | Method | Endpoint |
|---|---|---|
| Students | POST | `/api/students` |
| Students | GET | `/api/students` |
| Students | GET | `/api/students/{id}` |
| Students | PUT | `/api/students/{id}` |
| Students | PUT | `/api/students/{id}/deactivate` |
| Students | PUT | `/api/students/{id}/skills` |
| Students | DELETE | `/api/students/{id}` |
| Companies | POST | `/api/companies` |
| Companies | GET | `/api/companies` |
| Companies | GET | `/api/companies/{id}` |
| Companies | PUT | `/api/companies/{id}` |
| Companies | PUT | `/api/companies/{id}/deactivate` |
| Jobs | POST | `/api/jobs` |
| Jobs | GET | `/api/jobs` |
| Jobs | GET | `/api/jobs/{id}` |
| Jobs | PUT | `/api/jobs/{id}` |
| Jobs | PUT | `/api/jobs/{id}/deactivate` |
| Applications | POST | `/api/applications` |
| Applications | GET | `/api/applications` |
| Applications | GET | `/api/applications/{id}` |
| Applications | PUT | `/api/applications/{id}/status?status={value}` |
| Interviews | POST | `/api/interviews` |
| Interviews | GET | `/api/interviews` |
| Interviews | GET | `/api/interviews/{id}` |
| Interviews | PUT | `/api/interviews/{id}/result?result={value}` |
| Interviews | PUT | `/api/interviews/{id}/feedback?feedback={value}` |
| Placements | POST | `/api/placements` |
| Placements | GET | `/api/placements` |
| Placements | GET | `/api/placements/{id}` |
| Placements | PUT | `/api/placements/{id}/status?status={value}` |
| Placements | DELETE | `/api/placements/{id}` |
| Dashboard | GET | `/api/dashboard/summary` |

Request fields, allowed status values, and validation rules are defined in the corresponding DTOs, enums, and service classes.

## Data Model

- **Student:** Student profile and academic/skill information.
- **Skill:** Skills associated with students.
- **Company:** Recruiter and company information.
- **Job:** Job posting details.
- **Application:** A student's application and its status.
- **Interview:** Interview scheduling, results, and feedback.
- **Placement:** Placement details and placement status.

The project includes enums for application status, interview results, and placement status.

## Author

**Gayatri Tonde**

- GitHub: [@gayatri-tonde](https://github.com/gayatri-tonde)
- Repository: [placementManagementSystem](https://github.com/gayatri-tonde/placementManagementSystem)
