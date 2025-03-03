package com.reaosen.management_system.DTO;

import lombok.Data;

import java.util.List;

@Data
public class DrilldownBarChartDTO {
    private List<String> categories; // X轴类别数据
    private List<Integer> seriesData; // Y轴数据
}
