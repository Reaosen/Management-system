package com.reaosen.management_system.Exception;

public class CustomizeException extends RuntimeException{
    private Integer code;
    private String message;
    private Integer httpStatus;

    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
        this.httpStatus = errorCode.getHttpStatus();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }

    public Integer getHttpStatus() {
        return httpStatus;
    }
}
