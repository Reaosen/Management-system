package com.reaosen.management_system.Controller;

import com.reaosen.management_system.DTO.PaginationDTO;
import com.reaosen.management_system.DTO.ResultDTO;
import com.reaosen.management_system.Model.DisposalPoint;
import com.reaosen.management_system.Model.TransportRecord;
import com.reaosen.management_system.Service.wasteService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.transform.Result;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class wasteController {

    @Autowired
    private wasteService wasteService;

    @GetMapping("/waste/collection")
    public String wasteCollection() {
        return "wasteCollection";
    }

    @GetMapping("/waste/disposal")
    public String wasteDisposal() {
        return "wasteDisposal";
    }

    @GetMapping("/waste/transportation")
    public String wasteTransportation() {
        return "wasteTransportation";
    }

    @GetMapping("/waste/transportation/pagination")
    @ResponseBody
    public PaginationDTO wasteTransportationPagination(HttpServletRequest request, Model model, @RequestParam(value = "sEcho") Integer sEcho, @RequestParam(value = "iDisplayStart", defaultValue = "0") Integer iDisplayStart, @RequestParam(value = "iDisplayLength", defaultValue = "10") Integer iDisplayLength, @RequestParam(value = "sSearch", defaultValue = "") String sSearch) {

        PaginationDTO pagination = wasteService.wastePagination("transportation", sEcho, iDisplayStart, iDisplayLength, sSearch);
        return pagination;
    }

    @GetMapping("/waste/disposal/pagination")
    @ResponseBody
    public PaginationDTO wasteDisposalPagination(HttpServletRequest request, Model model, @RequestParam(value = "sEcho") Integer sEcho, @RequestParam(value = "iDisplayStart", defaultValue = "0") Integer iDisplayStart, @RequestParam(value = "iDisplayLength", defaultValue = "10") Integer iDisplayLength, @RequestParam(value = "sSearch", defaultValue = "") String sSearch) {

        PaginationDTO pagination = wasteService.wastePagination("disposal", sEcho, iDisplayStart, iDisplayLength, sSearch);
        return pagination;
    }

    @GetMapping("/waste/collection/pagination")
    @ResponseBody
    public PaginationDTO wasteCollectionPagination(HttpServletRequest request, Model model, @RequestParam(value = "sEcho") Integer sEcho, @RequestParam(value = "iDisplayStart", defaultValue = "0") Integer iDisplayStart, @RequestParam(value = "iDisplayLength", defaultValue = "10") Integer iDisplayLength, @RequestParam(value = "sSearch", defaultValue = "") String sSearch) {

        PaginationDTO pagination = wasteService.wastePagination("collection", sEcho, iDisplayStart, iDisplayLength, sSearch);
        return pagination;
    }

    @GetMapping("/waste/collection/form")
    public String wasteCollectionForm(HttpServletRequest request, Model model) {

        Map<String, List<String>> result = wasteService.initCollectionForm();
        List<String> wasteTypes = new ArrayList<>(result.get("wasteTypes"));
        List<String> collectionPoints = new ArrayList<>(result.get("collectionPoints"));
        model.addAttribute("wasteTypes", wasteTypes);
        model.addAttribute("collectionPoints", collectionPoints);

        return "wasteCollectionForm";
    }

    @PostMapping("/waste/collection/insert")
    public String wasteCollectionInsert(@RequestParam Integer wasteTypeId, @RequestParam Integer collectionPointId, @RequestParam BigDecimal weight, @RequestParam Integer collectionAccountId) {
        wasteService.wasteCollectionInsert(wasteTypeId, collectionPointId, weight, collectionAccountId);
        return "redirect:/waste/collection";
    }

    @GetMapping("/waste/disposal/form")
    public String wasteDisposalForm(HttpServletRequest request, Model model) {
        List result = wasteService.initDisposalForm();
        model.addAttribute("initDisposalForm", result);
        return "wasteDisposalForm";
    }

    @GetMapping("/waste/disposal/form/secondaryMenu")
    @ResponseBody
    public List wasteDisposalFormSecondaryMenu(@RequestParam Integer disposalPointId) {
        List result = wasteService.wasteDisposalFormSecondaryMenu(disposalPointId);
        return result;
    }

    @PostMapping("/waste/disposal/insert")
    public String wasteDisposalInsert(@RequestParam Integer disposalPointId, @RequestParam Integer wasteRecordId, @RequestParam String disposalMethod, @RequestParam Integer collectionAccountId) {
        wasteService.wasteDisposalInsert(disposalPointId, wasteRecordId, disposalMethod, collectionAccountId);
        return "redirect:/waste/disposal";
    }

}
