package com.reaosen.management_system.DTO;

import lombok.Data;

@Data
public class UserWorkDTO {
    private Integer accountId;
    private String username;
    private String role;
    private Integer todayData;
    private Integer monthData;
}
