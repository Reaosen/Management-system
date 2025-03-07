package com.reaosen.management_system.DTO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CollectionPointDTO {
    private Integer collectionPointId;
    private String address;
    private BigDecimal usedCapacity;
    private BigDecimal remainingCapacity;

}
