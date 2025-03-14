package com.reaosen.management_system.Controller;

import com.reaosen.management_system.DTO.ResultDTO;
import com.reaosen.management_system.DTO.TempUserDTO;
import com.reaosen.management_system.Service.LoginService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Object Login(@RequestBody TempUserDTO tempUserDTO, HttpServletResponse response) {
        loginService.login(tempUserDTO, response);
        return ResultDTO.okOf();
    }

    //用户登出
    @GetMapping("/logout")
    public String logout(HttpServletRequest request,
                         HttpServletResponse response) {
        request.getSession().removeAttribute("user");
        Cookie cookie = new Cookie("token", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/login";
    }
}
