package com.reaosen.management_system.Controller;

import com.reaosen.management_system.DTO.PaginationDTO;
import com.reaosen.management_system.DTO.ResultDTO;
import com.reaosen.management_system.Service.EmployeeService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public String Employee() {
        return "employee";
    }

    @GetMapping("/employee/pagination")
    @ResponseBody
    public PaginationDTO pagination(HttpServletRequest request,
                              Model model,
                              @RequestParam(value = "sEcho") Integer sEcho,
                              @RequestParam(value = "iDisplayStart", defaultValue = "0") Integer iDisplayStart,
                              @RequestParam(value = "iDisplayLength", defaultValue = "10") Integer iDisplayLength,
                              @RequestParam(value = "sSearch", defaultValue = "") String sSearch) {
        PaginationDTO pagination = employeeService.pagination(sEcho, iDisplayStart, iDisplayLength, sSearch);
        model.addAttribute("pagination", pagination);

        return pagination;
    }
}
