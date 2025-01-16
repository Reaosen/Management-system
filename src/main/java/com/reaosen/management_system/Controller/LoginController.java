package com.reaosen.management_system.Controller;

import com.reaosen.management_system.DTO.ResultDTO;
import com.reaosen.management_system.DTO.UserDTO;
import com.reaosen.management_system.Service.LoginService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Object Login(@RequestBody UserDTO userDTO, HttpServletResponse response){

        return ResultDTO.okOf();
    }
}
