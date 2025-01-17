package com.reaosen.management_system.Service;

import com.reaosen.management_system.DTO.UserDTO;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

public interface LoginService {
    public void login(UserDTO userDTO, HttpServletResponse response);
}
