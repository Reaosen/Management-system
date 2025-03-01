package com.reaosen.management_system.Utils;

import java.time.*;
import java.time.temporal.TemporalAdjusters;

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

    public static Integer getWeekStartTimestamp() {
        // 获取当前日期
        LocalDate today = LocalDate.now();
        // 获取本周周一的日期
        LocalDate monday = today.with(TemporalAdjusters.previousOrSame(java.time.DayOfWeek.MONDAY));
        // 将周一的日期设置为零点
        LocalDateTime mondayAtStartOfDay = monday.atStartOfDay();
        // 转换为时间戳
        long epochSecond = mondayAtStartOfDay.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
        return Math.toIntExact(epochSecond);
    }

    public static Integer getCurrentTimestamp() {
        // 获取当前时间
        LocalDateTime now = LocalDateTime.now();
        // 转换为时间戳
        long epochSecond = now.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
        return Math.toIntExact(epochSecond);
    }

    public static Integer getStartOfLastWeekTimestamp() {
        // 获取当前日期
        LocalDate today = LocalDate.now();

        // 获取当前星期的星期一
        LocalDate startOfWeek = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));

        // 获取上一个星期的星期一
        LocalDate startOfLastWeek = startOfWeek.minusWeeks(1);

        // 将 LocalDate 转换为 LocalDateTime（零点）
        LocalDateTime startOfLastWeekDateTime = LocalDateTime.of(startOfLastWeek, java.time.LocalTime.MIDNIGHT);

        // 将 LocalDateTime 转换为十位时间戳
        Integer startOfLastWeekTimestamp = Math.toIntExact(startOfLastWeekDateTime.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond());

        return startOfLastWeekTimestamp;
    }




}
