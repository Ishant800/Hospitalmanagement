//package com.example.HospitalManagementSystem.exception;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//public class CustomExceptions {
//
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public class ResourceNotFoundException extends RuntimeException{
//        public ResourceNotFoundException(String msg){
//            super(msg);
//        }a
//    }
//
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public class BadRequestException extends RuntimeException{
//        public BadRequestException(String msg){
//            super(msg);
//        }
//    }
//
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    public class UnauthorizedException extends RuntimeException {
//        public UnauthorizedException(String msg) {
//            super(msg);
//        }
//    }
//
//    @ResponseStatus(HttpStatus.CONFLICT)
//    public class ConflictException extends RuntimeException {
//        public ConflictException(String msg) {
//            super(msg);
//        }
//    }
//
//}
