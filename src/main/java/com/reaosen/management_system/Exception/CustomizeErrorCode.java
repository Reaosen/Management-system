package com.reaosen.management_system.Exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode{

    QUESTION_NOT_FOUND(2001, "你找的问题不在了，要不要换一个试试？"),
    TARGET_PARAM_NOT_FOUND(2002, "未选中任何问题或评论进行回复。"),
    NO_LOGIN(2003, "未登录，请先登录再尝试该操作。"),
    SYS_ERROR(2004, "服务器着火了，我们正在灭火！"),
    TYPE_PARAM_WRONG(2005,"评论类型错误或不存在。"),
    COMMENT_NOT_FOUND(2006, "你找的评论不在了，要不要换一个试试？"),
    IS_EMPTY(2007, "输入内容不能为空。"),
    READ_NOTIFICATION_FAIL(2008, "不能看别人的信息哦。"),
    NOTIFICATION_NOT_FOUND(2009, "你找的消息不在了，要不要换一个试试？"),
    EMAIL_CODE_WRONG(2010, "验证码或邮箱错误。"),
    USER_NOT_FOUND(2011,"欸？没有见过你啊？先去注册吧。" ),
    PASSWORD_OR_EMAIL_WRONG(2012, "用户名或密码错误。");

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
