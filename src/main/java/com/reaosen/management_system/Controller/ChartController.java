package com.reaosen.management_system.Controller;

import com.reaosen.management_system.DTO.LineChartDataDTO;
import com.reaosen.management_system.DTO.PieChartDataDTO;
import com.reaosen.management_system.DTO.ResultDTO;
import com.reaosen.management_system.Service.WasteService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ChartController {

    @Autowired
    private WasteService wasteService;

    @GetMapping("/chart/indexPieChartData")
    @ResponseBody
    public ResultDTO wasteTypeDistribute(HttpServletRequest request) {
        List<PieChartDataDTO> result = wasteService.getWasteTypeDistribute();
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
}
