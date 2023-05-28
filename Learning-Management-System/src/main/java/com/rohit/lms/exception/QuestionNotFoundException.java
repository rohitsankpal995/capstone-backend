package com.rohit.lms.exception;

public class QuestionNotFoundException extends RuntimeException{

    public QuestionNotFoundException(String msg){
        super(msg);
    }
}
