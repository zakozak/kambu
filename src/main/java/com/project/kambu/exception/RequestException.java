package com.project.kambu.exception;

public class RequestException extends RuntimeException {

    private ExceptionCode type;

    public RequestException(String message, ExceptionCode type) {
        super(message);
        this.type = type;
    }

    public ExceptionCode getStatus() {
        return type;
    }
}