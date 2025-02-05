package com.reaosen.management_system.Controller;

import com.reaosen.management_system.Service.IndexService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
public class indexController {

    @Autowired
    private IndexService indexService;

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model) {

        return "index";
    }
}
