package com.reaosen.management_system.Controller;

import com.reaosen.management_system.DTO.DrilldownBarChartDTO;
import com.reaosen.management_system.DTO.LineChartDataDTO;
import com.reaosen.management_system.DTO.PieChartDataDTO;
import com.reaosen.management_system.DTO.ResultDTO;
import com.reaosen.management_system.Service.WasteService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ChartController {

    @Autowired
    private WasteService wasteService;

    @GetMapping("/chart/indexWasteTypePieChartData")
    @ResponseBody
    public ResultDTO wasteTypeDistribute(HttpServletRequest request) {
        List<PieChartDataDTO> result = wasteService.getWasteTypeDistribute();
        return ResultDTO.okOf(result);
    }
    @GetMapping("/chart/indexDisposalPointPieChartData")
    @ResponseBody
    public ResultDTO disposalPointDistribute(HttpServletRequest request) {
        List<PieChartDataDTO> result = wasteService.getDisposalPointDistribute();
        return ResultDTO.okOf(result);
    }

    @GetMapping("/chart/indexLineChartData/{dataType}")
    @ResponseBody
    public ResultDTO<LineChartDataDTO> getLineChartData(@PathVariable String dataType) {
        LineChartDataDTO lineChartDataDTO = wasteService.getWeekDataByType(dataType);

        // 返回封装后的数据
        return ResultDTO.okOf(lineChartDataDTO);
    }

    @GetMapping("/chart/wasteChart")
    public String collectionChart(){
        return "wasteChart";
    }

    @GetMapping("/chart/wasteChartByMonth")
    @ResponseBody
    public ResultDTO collectionChart(@RequestParam Integer year, @RequestParam Integer month) {
        LineChartDataDTO lineChartDataDTO = wasteService.getWasteDataByMonth(year, month);
        return ResultDTO.okOf(lineChartDataDTO);
    }

    @GetMapping("/chart/report")
    public String report(Model model) {

        List disposalMethods = wasteService.getDisposalMethods();
        List collectionPoints = wasteService.getCollectionPoints();
        List mainSourcesCollectionPoints = wasteService.getMainWasteCollectionPoints();
        List mainDisposalMethods = wasteService.getMainDisposalMethods();
        String mainQuarter = wasteService.getmainQuarter();

        model.addAttribute("collectionPoints", collectionPoints);
        model.addAttribute("wasteTypes", disposalMethods);
        model.addAttribute("mainSourcesCollectionPoints", mainSourcesCollectionPoints);
        model.addAttribute("disposalMethods", disposalMethods);
        model.addAttribute("mainDisposalMethods", mainDisposalMethods);
        model.addAttribute("mainQuarter", mainQuarter);

        return "report";
    }

    @GetMapping("/chart/reportCollectionPointsChartByMonth")
    @ResponseBody
    public ResultDTO reportCollectionPointsPieChart(@RequestParam Integer year, @RequestParam Integer month) {
        List<PieChartDataDTO> PieChartDataDTOs = wasteService.getCollectionPointsDataByMonth(year, month);
        return ResultDTO.okOf(PieChartDataDTOs);
    }

    @GetMapping("/chart/reportDisposalMethodsChartByMonth")
    @ResponseBody
    public ResultDTO reportDisposalPieChart(@RequestParam Integer year, @RequestParam Integer month) {
        List<PieChartDataDTO> PieChartDataDTOs = wasteService.getDisposalMethodsDataByMonth(year, month);
        return ResultDTO.okOf(PieChartDataDTOs);
    }

    @GetMapping("/chart/reportTimeBarChart")
    @ResponseBody
    public ResultDTO getInitialData() {
        DrilldownBarChartDTO barChartDTO = wasteService.getInitialQuarterData();
        return ResultDTO.okOf(barChartDTO);
    }

    // 获取钻取数据
    @GetMapping("/chart/drilldownReportTimeBarChartData")
    @ResponseBody
    public ResultDTO getDrilldownData(@RequestParam String groupId) {
        DrilldownBarChartDTO barChartDTO = wasteService.getDrilldownInitialQuarterData(groupId);
        return ResultDTO.okOf(barChartDTO);
    }

}
