package com.reaosen.management_system.Controller;

import com.reaosen.management_system.DTO.*;
import com.reaosen.management_system.Mapper.UserMapper;
import com.reaosen.management_system.Model.User;
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

        User user = (User) request.getSession().getAttribute("user");
        // 通用接口
        String collectionWOW = wasteService.getWOWdataByType("collection");
        String transportWOW = wasteService.getWOWdataByType("transport");
        String disposalWOW = wasteService.getWOWdataByType("disposal");
        String allWOW = wasteService.getWOWdataByType("all");
        List<UserContributionDTO> userContributions = userService.getUsersWeeklyContribution();
        model.addAttribute("collectionWOW", collectionWOW);
        model.addAttribute("transportWOW", transportWOW);
        model.addAttribute("disposalWOW", disposalWOW);
        model.addAttribute("allWOW", allWOW);
        model.addAttribute("userContributions", userContributions);

        // 管理员中控接口
        if (user != null && user.getPermission().equals("admin")) {
            Integer collectionTodayTotal = wasteService.getWasteTotalByTime("today", "collection");
            Integer disposalTodayTotal = wasteService.getWasteTotalByTime("today", "disposal");
            Integer transportTodayTotal = wasteService.getWasteTotalByTime("today", "transport");
            Integer todayWorkUsersCount = userService.getWorkUsersCountByTime("today");
            model.addAttribute("collectionTodayTotal", collectionTodayTotal);
            model.addAttribute("disposalTodayTotal", disposalTodayTotal);
            model.addAttribute("transportTodayTotal", transportTodayTotal);
            model.addAttribute("todayWorkUsersCount", todayWorkUsersCount);

            Integer allWeekTotal = wasteService.getWasteTotalByTime("week", "all");
            Integer allMonthTotal = wasteService.getWasteTotalByTime("month", "all");
            model.addAttribute("allWeekTotal", allWeekTotal);
            model.addAttribute("allMonthTotal", allMonthTotal);

        }

        // 收集工人接口
        if (user != null && user.getPermission().equals("collector")) {
            // TODO 仓储接口
            Integer taskProportion = wasteService.getUsedCapacityProportion(user.getRegionId());
            List<WasteTypesCapacityDTO> wasteTypesCapacityProportion = wasteService.getWasteTypesCapacityProportion(user.getRegionId());
            model.addAttribute("taskProportion", taskProportion);
            model.addAttribute("wasteTypesCapacityProportion", wasteTypesCapacityProportion);

            Integer weekTotal = wasteService.getWasteTotalByTime("week", "collection");
            Integer monthTotal = wasteService.getWasteTotalByTime("month", "collection");
            model.addAttribute("weekTotal", weekTotal);
            model.addAttribute("monthTotal", monthTotal);
        }
        // 司机接口
        if (user != null && user.getPermission().equals("driver")) {
            List<WasteDTO> unfinishedTasks = wasteService.getUnfinishedTransportTask();
            Integer taskProportion = wasteService.getTransportTaskProportion();
            model.addAttribute("unfinishedTasks", unfinishedTasks);
            model.addAttribute("taskProportion", taskProportion);

            Integer weekTotal = wasteService.getWasteTotalByTime("week", "transport");
            Integer monthTotal = wasteService.getWasteTotalByTime("month", "transport");
            model.addAttribute("weekTotal", weekTotal);
            model.addAttribute("monthTotal", monthTotal);
        }
        // 处理工人接口
        if (user != null && user.getPermission().equals("disposaler")) {
            List<WasteDTO> unfinishedTasks = wasteService.getUnfinishedDisposalTask();
            Integer taskProportion = wasteService.getDisposalTaskProportion();
            model.addAttribute("unfinishedTasks", unfinishedTasks);
            model.addAttribute("taskProportion", taskProportion);

            Integer weekTotal = wasteService.getWasteTotalByTime("week", "disposal");
            Integer monthTotal = wasteService.getWasteTotalByTime("month", "disposal");
            model.addAttribute("weekTotal", weekTotal);
            model.addAttribute("monthTotal", monthTotal);
        }


        return path;
    }

}
