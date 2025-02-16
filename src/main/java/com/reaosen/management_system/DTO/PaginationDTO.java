package com.reaosen.management_system.DTO;

import lombok.Data;

import java.util.List;

@Data
public class PaginationDTO<T> {
    private Integer sEcho; // DataTables 请求的次数
    private Long iTotalRecords; // 总记录数
    private Long iTotalDisplayRecords; // 筛选后的记录数
    private List<T> aaData; // 当前页的数据

}
