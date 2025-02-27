package com.reaosen.management_system.Controller;

import com.reaosen.management_system.DTO.WasteDTO;
import com.reaosen.management_system.Model.User;
import com.reaosen.management_system.Model.WasteRecord;
import com.reaosen.management_system.Service.WasteService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProfileController {

    @Autowired
    private WasteService wasteService;

    @GetMapping("/user/profile")
    public String profile(HttpServletRequest request,
                          Model model) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null){
            //todo 未登录提醒
            return "redirect:/login";
        }
        Integer todayTotal = wasteService.getWorkTotalByTypeAndAccountId("today", user.getAccountId());
        model.addAttribute("todayTotal", todayTotal);
        Integer weekTotal = wasteService.getWorkTotalByTypeAndAccountId("week", user.getAccountId());
        model.addAttribute("weekTotal", weekTotal);
        Integer monthTotal = wasteService.getWorkTotalByTypeAndAccountId("month", user.getAccountId());
        model.addAttribute("monthTotal", monthTotal);
        List<WasteDTO> wasteDTOs = wasteService.getWorkDataByTypeAndAccountId("week", user.getAccountId());
        model.addAttribute("wasteDTOs", wasteDTOs);

        return "userProfile";
    }
}
