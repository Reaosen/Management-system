package com.reaosen.management_system.Service;

import com.reaosen.management_system.DTO.TempUserDTO;
import jakarta.servlet.http.HttpServletResponse;

public interface LoginService {
    public void login(TempUserDTO userDTO, HttpServletResponse response);
}
