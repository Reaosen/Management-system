package com.reaosen.management_system.Enumeration;

public enum PayStatusType {
    UNPAID("未支付"),
    PAID("已支付"),
    UNPAID_PAYMENT("未入账"),
    PAID_PAYMENT("已入账");

    public String message;

    PayStatusType(String payStatus) {
        this.message = payStatus;
    }
}
