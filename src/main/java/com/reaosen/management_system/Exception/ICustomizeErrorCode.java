package com.reaosen.management_system.Exception;

public interface ICustomizeErrorCode {
    String getMessage();
    Integer getCode();
    Integer getHttpStatus();
}
