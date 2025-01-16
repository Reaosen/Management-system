package com.reaosen.management_system.DTO;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    @JSONField(name = "id")
    private Long accountId;
    private String password;
    private String email;
    private String name;
    private String bio;
    private String avatarUrl;
}
