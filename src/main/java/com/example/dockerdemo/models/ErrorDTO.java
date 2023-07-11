package com.example.dockerdemo.models;


public class ErrorDTO {

    private String errorCode;

    private String errorText;

    private Object result;


    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorText() {
        return errorText;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public ErrorDTO(String errorCode, String errorText, Object result) {
        this.errorCode = errorCode;
        this.errorText = errorText;
        this.result = result;
    }
}
