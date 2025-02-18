package com.reaosen.management_system.DTO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class WasteDTO {

    private Integer wasteRecordId;//收集编号
    private String wasteType;//废弃物类型
    private String collectionPoint;//收集点
    private Integer collectionTime;//收集时间
    private BigDecimal weight;//质量
    private String status;//状态
    private Integer transportId;//运输编号
    private String collectionusername;//收集人
    private String transportusername;//运输人
    private String disposalusername;//处理人
    private Integer transportTime;//运输时间
    private String transportVehicle;//运输信息
    private String disposalPoint;//处理地点
}
