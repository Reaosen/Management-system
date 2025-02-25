package com.reaosen.management_system.Controller;

import com.reaosen.management_system.DTO.PaginationDTO;
import com.reaosen.management_system.DTO.WasteDTO;
import com.reaosen.management_system.Service.wasteService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

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

        List wasteTypes = wasteService.getWasteTypes();
        List collectionPoints = wasteService.getCollectionPoints();
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
        List disposalPoints = wasteService.getDisposalPoints();
        model.addAttribute("disposalPoints", disposalPoints);
        return "wasteDisposalForm";
    }

    @GetMapping("/waste/disposal/form/secondaryMenu")
    @ResponseBody
    public List wasteDisposalFormSecondaryMenu(@RequestParam Integer disposalPointId) {
        List result = wasteService.getWastesByDisposalPointId(disposalPointId);
        return result;
    }

    @PostMapping("/waste/disposal/insert")
    public String wasteDisposalInsert(@RequestParam Integer disposalPointId, @RequestParam Integer wasteRecordId, @RequestParam String disposalMethod, @RequestParam Integer collectionAccountId) {
        wasteService.wasteDisposalInsert(disposalPointId, wasteRecordId, disposalMethod, collectionAccountId);
        return "redirect:/waste/disposal";
    }

    @GetMapping("/waste/transportation/form")
    public String wasteTransportationForm(HttpServletRequest request, Model model) {
        List collectionPoints = wasteService.getCollectionPoints();
        List disposalPoints = wasteService.getDisposalPoints();
        model.addAttribute("collectionPoints", collectionPoints);
        model.addAttribute("disposalPoints", disposalPoints);
        return "wasteTransportationForm";
    }

    @GetMapping("/waste/transportation/form/secondaryMenu")
    @ResponseBody
    public List wasteTransportationFormSecondaryMenu(@RequestParam Integer collectionPointId) {
        List result = wasteService.getWastesByCollectionPointId(collectionPointId);
        return result;
    }

    @PostMapping("/waste/transportation/insert")
    public String wasteTransportationInsert(@RequestParam Integer collectionPointId, @RequestParam Integer wasteRecordId, @RequestParam Integer disposalPointId, @RequestParam BigDecimal weight, @RequestParam String transportVehicle, @RequestParam Integer collectionAccountId) {
        wasteService.wasteTransportationInsert(collectionPointId, wasteRecordId, disposalPointId, weight, transportVehicle, collectionAccountId);
        return "redirect:/waste/transportation";
    }

    @GetMapping("/waste/{wasteRecordId}")
    public String wasteProfile(@PathVariable(value = "wasteRecordId") Integer wasteRecordId, Model model) {
        WasteDTO wasteDTO = wasteService.getWasteByWasteRecordId(wasteRecordId);
        model.addAttribute("wasteDTO", wasteDTO);
        return "wasteProfile";
    }

    @GetMapping("/waste/modify/{wasteRecordId}")
    public String wasteProfileModify(@PathVariable(value = "wasteRecordId") Integer wasteRecordId, Model model) {
        WasteDTO wasteDTO = wasteService.getWasteByWasteRecordId(wasteRecordId);
        model.addAttribute("wasteDTO", wasteDTO);

        return "wasteProfileModify";
    }


}
