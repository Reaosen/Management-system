package com.reaosen.management_system.Controller;

import com.reaosen.management_system.DTO.UserDTO;
import com.reaosen.management_system.DTO.WasteDTO;
import com.reaosen.management_system.Model.User;
import com.reaosen.management_system.Model.WasteRecord;
import com.reaosen.management_system.Service.UserService;
import com.reaosen.management_system.Service.WasteService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ProfileController {

    @Autowired
    private WasteService wasteService;

    @Autowired
    private UserService userService;

    @GetMapping("/user/profile/{accountId}")
    public String profile(HttpServletRequest request,
                          Model model,
                          @PathVariable Integer accountId) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null){
            //todo 未登录提醒
            return "redirect:/login";
        }
        UserDTO userDTO = userService.getUserByAccountId(accountId);
        Integer todayTotal = wasteService.getWorkTotalByTypeAndAccountId("today", accountId);
        Integer weekTotal = wasteService.getWorkTotalByTypeAndAccountId("week", accountId);
        Integer monthTotal = wasteService.getWorkTotalByTypeAndAccountId("month", accountId);
        List<WasteDTO> wasteDTOs = wasteService.getWorkDataByTypeAndAccountId("week", accountId);

        model.addAttribute("userDTO", userDTO);
        model.addAttribute("todayTotal", todayTotal);
        model.addAttribute("weekTotal", weekTotal);
        model.addAttribute("monthTotal", monthTotal);
        model.addAttribute("wasteDTOs", wasteDTOs);

        return "userProfile";
    }
}
