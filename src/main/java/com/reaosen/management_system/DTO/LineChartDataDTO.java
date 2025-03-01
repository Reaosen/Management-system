package com.reaosen.management_system.DTO;

import lombok.Data;

import java.util.List;

@Data
public class LineChartDataDTO {
    private List<String> categories;
    private List<LineSeriesDTO> series;

    public LineChartDataDTO(List<String> categories, List<LineSeriesDTO> series) {
        this.categories = categories;
        this.series = series;
    }
}

