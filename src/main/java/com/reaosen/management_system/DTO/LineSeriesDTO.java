package com.reaosen.management_system.DTO;

import lombok.Data;

import java.util.List;

// 用于封装单个系列的数据
@Data
public class LineSeriesDTO {
    private String name;
    private List<Integer> data;

    public LineSeriesDTO(String name, List<Integer> data) {
        this.name = name;
        this.data = data;
    }
}
