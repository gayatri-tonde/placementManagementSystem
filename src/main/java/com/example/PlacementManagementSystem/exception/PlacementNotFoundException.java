package com.example.PlacementManagementSystem.exception;

public class PlacementNotFoundException extends ResourceNotFoundException {

    public PlacementNotFoundException(String message) {
        super(message);
    }
}