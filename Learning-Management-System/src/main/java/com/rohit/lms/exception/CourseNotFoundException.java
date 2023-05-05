package com.rohit.lms.exception;

public class CourseNotFoundException extends RuntimeException {

    public CourseNotFoundException(String msg)
    {
        super("course not found");
    }
}
