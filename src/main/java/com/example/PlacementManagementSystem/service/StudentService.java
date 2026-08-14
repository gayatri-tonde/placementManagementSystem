package com.example.PlacementManagementSystem.service;

import com.example.PlacementManagementSystem.dto.student.StudentRequestDTO;
import com.example.PlacementManagementSystem.dto.student.StudentResponseDTO;
import com.example.PlacementManagementSystem.entity.Skill;
import com.example.PlacementManagementSystem.entity.Student;
import com.example.PlacementManagementSystem.exception.StudentNotFoundException;
import com.example.PlacementManagementSystem.repository.SkillRepository;
import com.example.PlacementManagementSystem.repository.StudentRepository;
import org.springframework.stereotype.Service;
import com.example.PlacementManagementSystem.exception.ResourceNotFoundException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final SkillRepository skillRepository;

    public StudentService(StudentRepository studentRepository,
                          SkillRepository skillRepository) {
        this.studentRepository = studentRepository;
        this.skillRepository = skillRepository;
    }

    // CREATE
    public StudentResponseDTO createStudent(StudentRequestDTO request) {

        Student student = new Student();

        student.setName(request.getName());
        student.setEmail(request.getEmail());
        student.setPhone(request.getPhone());
        student.setRollNumber(request.getRollNumber());
        student.setBranch(request.getBranch());
        student.setCgpa(request.getCgpa());
        student.setGraduationYear(request.getGraduationYear());
        student.setResumeUrl(request.getResumeUrl());

        Student savedStudent = studentRepository.save(student);

        return convertToResponse(savedStudent);
    }

    // GET ALL
    public List<StudentResponseDTO> getAllStudents() {

        return studentRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    // GET BY ID
    public StudentResponseDTO getStudentById(Long id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new  ResourceNotFoundException(
                                "Student not found with ID: " + id));

        return convertToResponse(student);
    }

    // UPDATE
    public StudentResponseDTO updateStudent(
            Long id,
            StudentRequestDTO request) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException(
                                "Student not found with ID: " + id));

        student.setName(request.getName());
        student.setEmail(request.getEmail());
        student.setPhone(request.getPhone());
        student.setRollNumber(request.getRollNumber());
        student.setBranch(request.getBranch());
        student.setCgpa(request.getCgpa());
        student.setGraduationYear(request.getGraduationYear());
        student.setResumeUrl(request.getResumeUrl());

        Student updatedStudent = studentRepository.save(student);

        return convertToResponse(updatedStudent);
    }

    // DELETE
    public void deleteStudent(Long id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException(
                                "Student not found with ID: " + id));

        studentRepository.delete(student);
    }

    // DEACTIVATE
    public StudentResponseDTO deactivateStudent(Long id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException(
                                "Student not found with ID: " + id));

        student.setActive(false);

        Student updatedStudent = studentRepository.save(student);

        return convertToResponse(updatedStudent);
    }

    // ADD SKILLS TO STUDENT
    public StudentResponseDTO addSkillsToStudent(
            Long studentId,
            Set<String> skillNames) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() ->
                        new StudentNotFoundException(
                                "Student not found with ID: " + studentId));

        Set<Skill> skills = new HashSet<>();

        for (String skillName : skillNames) {

            Skill skill = skillRepository
                    .findByNameIgnoreCase(skillName)
                    .orElseGet(() ->
                            skillRepository.save(
                                    new Skill(skillName)));

            skills.add(skill);
        }

        student.setSkills(skills);

        Student updatedStudent = studentRepository.save(student);

        return convertToResponse(updatedStudent);
    }

    // ENTITY → RESPONSE DTO
    private StudentResponseDTO convertToResponse(Student student) {

        Set<String> skillNames = student.getSkills()
                .stream()
                .map(Skill::getName)
                .collect(Collectors.toSet());

        return new StudentResponseDTO(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getPhone(),
                student.getRollNumber(),
                student.getBranch(),
                student.getCgpa(),
                student.getGraduationYear(),
                student.getResumeUrl(),
                student.getActive(),
                skillNames
        );
    }
}