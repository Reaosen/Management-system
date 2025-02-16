package com.reaosen.management_system.DTO;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    @JSONField(name = "id")
    private Long accountId;
    private String email;
    private String username;
    private String avatarUrl;
    private String role;
    private String phone;
    private String token;
    private String permission;
    private String status;
}
