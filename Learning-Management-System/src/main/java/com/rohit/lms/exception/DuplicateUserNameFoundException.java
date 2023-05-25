package com.rohit.lms.exception;

public class DuplicateUserNameFoundException extends RuntimeException {
    public DuplicateUserNameFoundException(String msg) {
        super(msg);
    }
}
