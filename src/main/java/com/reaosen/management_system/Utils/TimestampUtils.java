package com.reaosen.management_system.Utils;

import java.time.*;

public class TimestampUtils {
    public static Integer getTodayStartTimestamp() {
        // 获取当天的起始时间（00:00:00）
        LocalDateTime startOfDay = LocalDate.now().atStartOfDay();
        long epochSecond = startOfDay.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
        return Math.toIntExact(epochSecond);
    }

    public static Integer getMonthStartTimestamp() {
        // 获取当前日期的本月第一天的日期
        LocalDate firstDayOfMonth = LocalDate.now().withDayOfMonth(1);
        // 将日期设置为0点
        LocalDateTime startOfMonth = firstDayOfMonth.atStartOfDay();
        // 转换为时间戳
        long epochSecond = startOfMonth.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
        return Math.toIntExact(epochSecond);
    }

    public static Integer getCurrentTimestamp() {
        // 获取当前时间
        LocalDateTime now = LocalDateTime.now();
        // 转换为时间戳
        long epochSecond = now.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
        return Math.toIntExact(epochSecond);
    }




}
