package com.reba.exception;

public class ApiCustomException extends RuntimeException {
    public ApiCustomException(String message) {
        super(message);
    }

    public ApiCustomException(String message, Throwable cause) {
        super(message, cause);
    }
}
