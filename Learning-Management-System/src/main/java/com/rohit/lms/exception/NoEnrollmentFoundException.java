package com.rohit.lms.exception;

public class NoEnrollmentFoundException extends RuntimeException {
    public NoEnrollmentFoundException(String msg){
        super(msg);
    }
}
