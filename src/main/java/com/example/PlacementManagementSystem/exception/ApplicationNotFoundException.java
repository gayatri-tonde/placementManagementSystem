package com.example.PlacementManagementSystem.exception;

public class ApplicationNotFoundException extends ResourceNotFoundException{

    public ApplicationNotFoundException(String message) {
        super(message);
    }
}