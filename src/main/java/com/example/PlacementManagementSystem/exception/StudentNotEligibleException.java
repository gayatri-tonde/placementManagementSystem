package com.example.PlacementManagementSystem.exception;

public class StudentNotEligibleException extends ResourceNotFoundException {

    public StudentNotEligibleException(String message) {
        super(message);
    }
}