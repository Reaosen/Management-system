package com.reaosen.management_system.Exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode{

    SYS_ERROR(2001, "服务器繁忙，请稍后再试或联系管理员。"),
    TNO_LOGIN(2002, "未登录，请先登录再尝试该操作。"),
    IS_EMPTY(2003, "输入内容不能为空。"),
    PASSWORD_OR_EMAIL_WRONG(2004, "用户名或密码错误。"),
    USER_NOT_FOUND(2005, "用户不存在，请联系管理员"),
    //TODO 账户禁用检测
    ACCOUNT_DISABLED(2006, "您的账户已被禁用，请联系管理员"),
    //TODO 账户权限检测
    NO_AUTHORITY(2007, "您无此操作的权限，请联系管理员")
    ;


    private String message;
    private Integer code;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {return code;}

    CustomizeErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
