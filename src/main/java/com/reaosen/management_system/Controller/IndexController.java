package com.reaosen.management_system.Controller;

import com.reaosen.management_system.DTO.PieChartDataDTO;
import com.reaosen.management_system.DTO.ResultDTO;
import com.reaosen.management_system.DTO.UserContributionDTO;
import com.reaosen.management_system.Mapper.UserMapper;
import com.reaosen.management_system.Service.IndexService;
import com.reaosen.management_system.Service.UserService;
import com.reaosen.management_system.Service.WasteService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
public class IndexController {

    @Autowired
    private IndexService indexService;

    @Autowired
    private WasteService wasteService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(HttpServletRequest request, Model model) {
        String path = indexService.index(request);
        Integer collectionTodayTotal= wasteService.getWasteTotalByTime("today", "collection");
        Integer disposalTodayTotal= wasteService.getWasteTotalByTime("today", "disposal");
        Integer transportTodayTotal= wasteService.getWasteTotalByTime("today", "transport");
        Integer allWeekTotal = wasteService.getWasteTotalByTime("week", "all");
        Integer allMonthTotal = wasteService.getWasteTotalByTime("month", "all");
        Integer todayWorkUsersCount = userService.getWorkUsersCountByTime("today");
        String collectionWOW = wasteService.getWOWdataByType("collection");
        String transportWOW = wasteService.getWOWdataByType("transport");
        String disposalWOW = wasteService.getWOWdataByType("disposal");
        String allWOW = wasteService.getWOWdataByType("all");

        List<UserContributionDTO> userContributions = userService.getUsersWeeklyContribution();


        model.addAttribute("collectionTodayTotal", collectionTodayTotal);
        model.addAttribute("disposalTodayTotal", disposalTodayTotal);
        model.addAttribute("transportTodayTotal", transportTodayTotal);
        model.addAttribute("allWeekTotal", allWeekTotal);
        model.addAttribute("allMonthTotal", allMonthTotal);
        model.addAttribute("todayWorkUsersCount", todayWorkUsersCount);
        model.addAttribute("collectionWOW", collectionWOW);
        model.addAttribute("transportWOW", transportWOW);
        model.addAttribute("disposalWOW", disposalWOW);
        model.addAttribute("allWOW", allWOW);
        model.addAttribute("userContributions", userContributions);


        return path;
    }

}
