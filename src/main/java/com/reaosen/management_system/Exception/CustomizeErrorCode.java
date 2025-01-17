package com.reaosen.management_system.Exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode{

    SYS_ERROR(2001, "服务器繁忙，请稍后再试或联系管理员。", 500),
    TNO_LOGIN(2002, "未登录，请先登录再尝试该操作。", 401),
    IS_EMPTY(2003, "输入内容不能为空。", 400),
    PASSWORD_OR_EMAIL_WRONG(2004, "用户名或密码错误。", 401),
    USER_NOT_FOUND(2005, "用户不存在，请联系管理员", 404),
    COMMENT_NOT_FOUND(2006, "评论不存在。", 404);


    private String message;
    private Integer code;
    private Integer httpStatus;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {return code;}

    @Override
    public Integer getHttpStatus() {
        return httpStatus;
    }

    CustomizeErrorCode(Integer code, String message, Integer httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
