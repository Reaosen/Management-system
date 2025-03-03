package com.reaosen.management_system.Controller;

import com.reaosen.management_system.DTO.PaginationDTO;
import com.reaosen.management_system.DTO.ResultDTO;
import com.reaosen.management_system.DTO.UserDTO;
import com.reaosen.management_system.Exception.CustomizeErrorCode;
import com.reaosen.management_system.Exception.CustomizeException;
import com.reaosen.management_system.Model.User;
import com.reaosen.management_system.Model.WasteType;
import com.reaosen.management_system.Service.UserService;
import com.reaosen.management_system.Service.WasteService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private WasteService wasteService;

    @GetMapping("/employee")
    public String Employee() {
        return "employee";
    }

    @GetMapping("/employee/pagination")
    @ResponseBody
    public PaginationDTO employeePagination(HttpServletRequest request,
                                            Model model,
                                            @RequestParam(value = "sEcho") Integer sEcho,
                                            @RequestParam(value = "iDisplayStart", defaultValue = "0") Integer iDisplayStart,
                                            @RequestParam(value = "iDisplayLength", defaultValue = "10") Integer iDisplayLength,
                                            @RequestParam(value = "sSearch", defaultValue = "") String sSearch) {
        PaginationDTO pagination = userService.employeePagination(sEcho, iDisplayStart, iDisplayLength, sSearch);
        model.addAttribute("pagination", pagination);

        return pagination;
    }

    @GetMapping("/employee/work")
    public String EmployeeWork() {
        return "employeeWork";
    }

    @GetMapping("/employee/work/pagination")
    @ResponseBody
    public PaginationDTO employeeWorkPagination(HttpServletRequest request,
                                         Model model,
                                         @RequestParam(value = "sEcho") Integer sEcho,
                                         @RequestParam(value = "iDisplayStart", defaultValue = "0") Integer iDisplayStart,
                                         @RequestParam(value = "iDisplayLength", defaultValue = "10") Integer iDisplayLength,
                                         @RequestParam(value = "sSearch", defaultValue = "") String sSearch){

        PaginationDTO pagination = wasteService.employeeWorkPagination(sEcho, iDisplayStart, iDisplayLength, sSearch);

        return pagination;
    }

    @PostMapping("/employee/updateStatus")
    @ResponseBody
    public ResultDTO lockOrUnlock(@RequestBody UserDTO userDTO, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        if (!user.getPermission().equals("admin")){
            throw new CustomizeException(CustomizeErrorCode.NO_AUTHORITY);
        }
        userService.updateStatusByAccountId(userDTO);

        return ResultDTO.okOf();
    }
}
