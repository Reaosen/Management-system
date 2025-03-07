package com.reaosen.management_system.DTO;

import lombok.Data;

@Data
public class WasteTypesCapacityDTO {
    private Integer wasteTypeId;
    private String wasteTypeName;
    private Integer wasteCapacityProportion;
}
