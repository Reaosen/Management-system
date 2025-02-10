package com.reaosen.management_system.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class profileController {

    @GetMapping("/profile")
    public String profile(HttpServletRequest request) {
        return "profile";
    }
}
