package com.reaosen.management_system.Controller;

import com.reaosen.management_system.Model.User;
import com.reaosen.management_system.Model.UserExample;
import com.reaosen.management_system.Service.IndexService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
public class indexController {

    @Autowired
    private IndexService indexService;

    @GetMapping("/")
    public String index(HttpServletRequest request) {
        String path = indexService.index(request);
        return path;
    }
}
