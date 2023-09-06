package com.its.education.educationsite.exception;

public class StudentsNotFoundException extends RuntimeException {
    public StudentsNotFoundException(String message) {
        super(message);
    }
}