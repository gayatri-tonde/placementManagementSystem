package com.example.PlacementManagementSystem.exception;

public class JobNotFoundException extends ResourceNotFoundException{

    public JobNotFoundException(String message) {
        super(message);
    }
}