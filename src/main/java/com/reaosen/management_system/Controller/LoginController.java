package com.reaosen.management_system.Controller;

import com.reaosen.management_system.DTO.ResultDTO;
import com.reaosen.management_system.DTO.UserDTO;
import com.reaosen.management_system.Exception.CustomizeException;
import com.reaosen.management_system.Service.LoginService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Object Login(@RequestBody UserDTO userDTO, HttpServletResponse response){
        try {
            loginService.login(userDTO, response);
            return ResponseEntity.ok(ResultDTO.okOf());
        } catch (CustomizeException ex) {
            ResultDTO resultDTO = ResultDTO.errorOf(ex);
            return new ResponseEntity<>(resultDTO, HttpStatus.valueOf(ex.getHttpStatus()));
        }
    }
    //用户登出
    @GetMapping("/logout")
    public Object logout(HttpServletRequest request,
                                            HttpServletResponse response) {
        request.getSession().removeAttribute("user");
        Cookie cookie = new Cookie("token", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return ResponseEntity.ok(ResultDTO.okOf());
    }
}
