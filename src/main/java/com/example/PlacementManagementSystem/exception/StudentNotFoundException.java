package com.example.PlacementManagementSystem.exception;

public class StudentNotFoundException extends ResourceNotFoundException {

    public StudentNotFoundException(String message) {
        super(message);
    }
}