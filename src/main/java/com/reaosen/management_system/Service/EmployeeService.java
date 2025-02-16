package com.reaosen.management_system.Service;

import com.reaosen.management_system.DTO.PaginationDTO;
import com.reaosen.management_system.DTO.UserDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

public interface EmployeeService {
    PaginationDTO pagination(@RequestParam(value = "sEcho") Integer sEcho,
                             @RequestParam(value = "iDisplayStart", defaultValue = "0") Integer iDisplayStart,
                             @RequestParam(value = "iDisplayLength", defaultValue = "10") Integer iDisplayLength,
                             @RequestParam(value = "sSearch", defaultValue = "") String sSearch);
}
