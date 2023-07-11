package com.example.dockerdemo.exception;

import org.springframework.stereotype.Component;

@Component

public class CustomException extends RuntimeException {

    private static final long serialVersionUID =1;

    private String errorCode;

    private String errorMessage;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public CustomException() {

    }

    public CustomException(String errorCode,String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage= errorMessage;
    }
}
