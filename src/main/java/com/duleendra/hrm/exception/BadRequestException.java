package com.duleendra.hrm.exception;

public class BadRequestException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private String errorMessage;

    public BadRequestException() {
        super();
    }

    public BadRequestException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
