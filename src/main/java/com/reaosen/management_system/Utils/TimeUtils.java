package com.reaosen.management_system.Utils;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class TimeUtils {
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

    public static List<String> getDaysInMonth(int year, int month) {
        // 验证月份是否在有效范围内
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month must be between 1 and 12");
        }

        // 获取该月份的第一天
        LocalDate startOfMonth = LocalDate.of(year, month, 1);

        // 获取该月份的最后一天
        LocalDate endOfMonth = startOfMonth.with(TemporalAdjusters.lastDayOfMonth());

        // 创建一个列表存储日期
        List<String> days = new ArrayList<>();
        for (LocalDate date = startOfMonth; !date.isAfter(endOfMonth); date = date.plusDays(1)) {
            days.add(String.valueOf(date.getDayOfMonth())); // 添加日期的天数部分
        }

        return days;
    }

    public static Integer getStartOfMonthTimestamp(int year, int month) {
        // 验证月份是否在有效范围内
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month must be between 1 and 12");
        }

        // 获取该月份的第一天
        LocalDate startOfMonth = LocalDate.of(year, month, 1);

        // 将 LocalDate 转换为 ZonedDateTime（在 UTC 时区）
        ZonedDateTime zdt = startOfMonth.atStartOfDay(ZoneId.of("UTC"));

        // 将 ZonedDateTime 转换为十位时间戳
        long timestamp = zdt.toInstant().toEpochMilli() / 1000;

        // 将 long 类型的时间戳转换为 int 类型
        return Math.toIntExact(timestamp);
    }

    public static Integer getTimestampForMonth(int year, int month) {
        // 获取当前时间
        LocalDateTime now = LocalDateTime.now(ZoneId.systemDefault());

        // 检查给定的年份和月份是否与当前时间匹配
        if (now.getYear() == year && now.getMonthValue() == month) {
            // 如果是当前月份，返回当前时间的十位时间戳
            return (int) (System.currentTimeMillis() / 1000);
        } else {
            // 如果不是当前月份，找到那个月的最后一天的最后一秒
            LocalDateTime lastDayOfMonth = LocalDateTime.of(year, month, 1, 0, 0)
                    .with(TemporalAdjusters.lastDayOfMonth())
                    .withHour(23)
                    .withMinute(59)
                    .withSecond(59);

            // 将最后一天的最后一秒转换为十位时间戳
            return (int) (lastDayOfMonth.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli() / 1000);
        }
    }

    public static Integer getStartOfYearTimestamp() {
        // 获取当前年份
        int currentYear = LocalDate.now().get(ChronoField.YEAR);

        // 获取当前年份1月1日
        LocalDate startOfYear = LocalDate.of(currentYear, 1, 1);

        // 将 LocalDate 转换为 ZonedDateTime（在 UTC 时区）
        ZonedDateTime zdt = startOfYear.atStartOfDay(ZoneId.of("UTC"));

        // 将 ZonedDateTime 转换为十位时间戳
        long timestamp = zdt.toInstant().toEpochMilli() / 1000;

        // 将 long 类型的时间戳转换为 int 类型
        return Math.toIntExact(timestamp);
    }



}
