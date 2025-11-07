package com.example.HospitalManagementSystem.exception;

public abstract class BaseException extends RuntimeException{
    public BaseException(String msg){
        super(msg);
    }
}
