package com.reaosen.management_system.Controller;

import com.reaosen.management_system.Service.WasteService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WechatPayController {

    @Autowired
    private WasteService wasteService;

    @GetMapping("/weChatPay/{id}")
    public String weChatPay(@PathVariable Integer id, Model model) {
        model.addAttribute("id", id);
        return "weChatPay";
    }

    @GetMapping("/finishPaid/{id}")
    public String weChatPaying(@PathVariable Integer id) {

        wasteService.payForDisposal(id);

        return "redirect:/waste/" + id;
    }


}
