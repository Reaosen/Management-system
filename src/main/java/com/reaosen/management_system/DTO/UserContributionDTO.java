package com.reaosen.management_system.DTO;

import lombok.Data;

@Data
public class UserContributionDTO {
    private Integer accountId;
    private String username;
    private String avatarUrl;
    private String role;
    private Integer contribution;


}
