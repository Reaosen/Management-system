package com.reaosen.management_system.Exception;

import lombok.Getter;

@Getter
public class CustomizeException extends RuntimeException{
    private Integer code;
    private String message;

    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

}
