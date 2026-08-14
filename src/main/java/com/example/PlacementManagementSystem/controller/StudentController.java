package com.example.PlacementManagementSystem.controller;

import com.example.PlacementManagementSystem.dto.student.StudentRequestDTO;
import com.example.PlacementManagementSystem.dto.student.StudentResponseDTO;
import com.example.PlacementManagementSystem.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<StudentResponseDTO> createStudent(
            @Valid @RequestBody StudentRequestDTO request) {

        return new ResponseEntity<>(
                studentService.createStudent(request),
                HttpStatus.CREATED
        );
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>> getAllStudents() {

        return ResponseEntity.ok(
                studentService.getAllStudents()
        );
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> getStudentById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                studentService.getStudentById(id)
        );
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody StudentRequestDTO request) {

        return ResponseEntity.ok(
                studentService.updateStudent(id, request)
        );
    }

    // DEACTIVATE
    @PutMapping("/{id}/deactivate")
    public ResponseEntity<StudentResponseDTO> deactivateStudent(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                studentService.deactivateStudent(id)
        );
    }
    @PutMapping("/{id}/skills")
    public ResponseEntity<StudentResponseDTO> addSkillsToStudent(
            @PathVariable Long id,
            @RequestBody Set<String> skills) {

        return ResponseEntity.ok(
                studentService.addSkillsToStudent(id, skills)
        );
    }
    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(
            @PathVariable Long id) {

        studentService.deleteStudent(id);

        return ResponseEntity.noContent().build();
    }
}