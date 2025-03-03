package com.reaosen.management_system.Controller;

import com.reaosen.management_system.DTO.*;
import com.reaosen.management_system.Exception.CustomizeErrorCode;
import com.reaosen.management_system.Exception.CustomizeException;
import com.reaosen.management_system.Model.User;
import com.reaosen.management_system.Service.WasteService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class WasteController {

    @Autowired
    private WasteService wasteService;

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
    public String wasteCollectionInsert(@RequestParam Integer wasteTypeId, @RequestParam Integer collectionPointId, @RequestParam BigDecimal weight, @RequestParam Integer collectionAccountId, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (!user.getPermission().equals("collector") && !user.getPermission().equals("admin")){
            throw new CustomizeException(CustomizeErrorCode.NO_AUTHORITY);
        }
        wasteService.wasteCollectionInsert(wasteTypeId, collectionPointId, weight, collectionAccountId);
        return "redirect:/waste/collection";
    }

    @GetMapping("/waste/disposal/form")
    public String wasteDisposalForm(HttpServletRequest request, Model model) {
        List disposalPoints = wasteService.getDisposalPoints();
        List disposalMethods = wasteService.getDisposalMethods();
        model.addAttribute("disposalPoints", disposalPoints);
        model.addAttribute("disposalMethods", disposalMethods);
        return "wasteDisposalForm";
    }

    @GetMapping("/waste/disposal/form/secondaryMenu")
    @ResponseBody
    public List wasteDisposalFormSecondaryMenu(@RequestParam Integer disposalPointId) {
        List result = wasteService.getWastesByDisposalPointId(disposalPointId);
        return result;
    }

    @PostMapping("/waste/disposal/insert")
    public String wasteDisposalInsert(@RequestParam Integer disposalPointId, @RequestParam Integer wasteRecordId, @RequestParam Integer disposalMethodId, @RequestParam Integer collectionAccountId, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (!user.getPermission().equals("disposaler") && !user.getPermission().equals("admin")){
            throw new CustomizeException(CustomizeErrorCode.NO_AUTHORITY);
        }
        wasteService.wasteDisposalInsert(disposalPointId, wasteRecordId, disposalMethodId, collectionAccountId);
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
    public String wasteTransportationInsert(@RequestParam Integer collectionPointId, @RequestParam Integer wasteRecordId, @RequestParam Integer disposalPointId, @RequestParam BigDecimal weight, @RequestParam String transportVehicle, @RequestParam Integer collectionAccountId, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (!user.getPermission().equals("driver") && !user.getPermission().equals("admin")){
            throw new CustomizeException(CustomizeErrorCode.NO_AUTHORITY);
        }
        wasteService.wasteTransportationInsert(collectionPointId, wasteRecordId, disposalPointId, weight, transportVehicle, collectionAccountId);
        return "redirect:/waste/transportation";
    }

    @GetMapping("/waste/{wasteRecordId}")
    public String wasteProfile(@PathVariable(value = "wasteRecordId") Integer wasteRecordId, Model model) {
        WasteDTO wasteDTO = wasteService.getWasteByWasteRecordId(wasteRecordId);
        model.addAttribute("wasteDTO", wasteDTO);
        return "wasteProfile";
    }

    @GetMapping("/waste/collection/modify/{wasteRecordId}")
    public String wasteProfileCollectionModify(@PathVariable(value = "wasteRecordId") Integer wasteRecordId, Model model) {
        WasteDTO wasteDTO = wasteService.getWasteByWasteRecordId(wasteRecordId);
        List<StatusTypeDTO> statusTypeDTOs = wasteService.getStatuses();
        List wasteTypes = wasteService.getWasteTypes();
        List collectionPoints = wasteService.getCollectionPoints();
        List collectionUsers = wasteService.getUsersByRole("收集工人");

        model.addAttribute("wasteDTO", wasteDTO);
        model.addAttribute("statusTypeDTOs", statusTypeDTOs);
        model.addAttribute("wasteTypes", wasteTypes);
        model.addAttribute("collectionPoints", collectionPoints);
        model.addAttribute("collectionUsers", collectionUsers);
        return "wasteProfileCollectionModify";
    }

    @GetMapping("/waste/transportation/modify/{wasteRecordId}")
    public String wasteProfileTransportationModify(@PathVariable(value = "wasteRecordId") Integer wasteRecordId, Model model) {
        WasteDTO wasteDTO = wasteService.getWasteByWasteRecordId(wasteRecordId);
        List<StatusTypeDTO> statusTypeDTOs = wasteService.getStatuses();
        List wasteTypes = wasteService.getWasteTypes();
        List collectionPoints = wasteService.getCollectionPoints();
        List disposalPoints = wasteService.getDisposalPoints();
        List transportationUsers = wasteService.getUsersByRole("司机");

        model.addAttribute("wasteDTO", wasteDTO);
        model.addAttribute("statusTypeDTOs", statusTypeDTOs);
        model.addAttribute("wasteTypes", wasteTypes);
        model.addAttribute("collectionPoints", collectionPoints);
        model.addAttribute("disposalPoints", disposalPoints);
        model.addAttribute("transportationUsers", transportationUsers);
        return "wasteProfileTransportationModify";
    }

    @GetMapping("/waste/disposal/modify/{wasteRecordId}")
    public String wasteProfileDisposalModify(@PathVariable(value = "wasteRecordId") Integer wasteRecordId, Model model) {
        WasteDTO wasteDTO = wasteService.getWasteByWasteRecordId(wasteRecordId);
        List<StatusTypeDTO> statusTypeDTOs = wasteService.getStatuses();
        List wasteTypes = wasteService.getWasteTypes();
        List disposalPoints = wasteService.getDisposalPoints();
        List disposalUsers = wasteService.getUsersByRole("处理工人");

        model.addAttribute("wasteDTO", wasteDTO);
        model.addAttribute("statusTypeDTOs", statusTypeDTOs);
        model.addAttribute("wasteTypes", wasteTypes);
        model.addAttribute("disposalPoints", disposalPoints);
        model.addAttribute("disposalUsers", disposalUsers);
        return "wasteProfileDisposalModify";
    }

    @PostMapping("/waste/collection/update/{id}")
    public String wasteProfileCollectionUpdate(@PathVariable(value = "id") Integer wasteRecordId,
                                               @RequestParam Integer wasteTypeId,
                                               @RequestParam BigDecimal weight,
                                               @RequestParam Integer collectionPointId,
                                               @RequestParam String collectionTime,
                                               @RequestParam Integer statusId,
                                               @RequestParam Integer collectionAccountId,
                                               HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (!user.getPermission().equals("collector") && !user.getPermission().equals("admin")){
            throw new CustomizeException(CustomizeErrorCode.NO_AUTHORITY);
        }

        wasteService.wasteRecordUpdate(wasteRecordId, wasteTypeId, weight, collectionPointId, collectionTime, statusId, collectionAccountId);

        return "redirect:/waste/" + wasteRecordId;
    }

    @PostMapping("/waste/transportation/update/{id}")
    public String wasteProfileTransportationUpdate(@PathVariable(value = "id") Integer wasteRecordId,
                                                   @RequestParam Integer collectionPointId,
                                                   @RequestParam Integer disposalPointId,
                                                   @RequestParam String transportTime,
                                                   @RequestParam String transportVehicle,
                                                   @RequestParam Integer transportAccountId,
                                                   HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (!user.getPermission().equals("driver") && !user.getPermission().equals("admin")){
            throw new CustomizeException(CustomizeErrorCode.NO_AUTHORITY);
        }
        wasteService.transportRecordUpdateByWasteRecordId(wasteRecordId, collectionPointId, disposalPointId, transportTime, transportVehicle, transportAccountId);

        return "redirect:/waste/" + wasteRecordId;
    }

    @PostMapping("/waste/disposal/update/{id}")
    public String wasteProfileDisposalUpdate(@PathVariable(value = "id") Integer wasteRecordId,
                                             @RequestParam Integer disposalMethodId,
                                             @RequestParam Integer disposalPointId,
                                             @RequestParam String disposalTime,
                                             @RequestParam Integer disposalAccountId,
                                             HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (!user.getPermission().equals("disposaler") && !user.getPermission().equals("admin")){
            throw new CustomizeException(CustomizeErrorCode.NO_AUTHORITY);
        }
        wasteService.disposalRecordUpdateByWasteRecordId(wasteRecordId, disposalMethodId, disposalPointId, disposalTime, disposalAccountId);
        return "redirect:/waste/" + wasteRecordId;
    }

    @DeleteMapping("/waste/collection/delete/{id}")
    @ResponseBody
    public ResultDTO wasteProfileCollectionDelete(@PathVariable(value = "id") Integer wasteRecordId, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (!user.getPermission().equals("collector") && !user.getPermission().equals("admin")){
            throw new CustomizeException(CustomizeErrorCode.NO_AUTHORITY);
        }

        wasteService.wasteRecordDelete(wasteRecordId);

        return ResultDTO.okOf();
    }

    @DeleteMapping("/waste/transportation/delete/{id}")
    @ResponseBody
    public ResultDTO wasteProfileTransportationDelete(@PathVariable(value = "id") Integer wasteRecordId, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (!user.getPermission().equals("driver") && !user.getPermission().equals("admin")){
            throw new CustomizeException(CustomizeErrorCode.NO_AUTHORITY);
        }

        wasteService.transportRecordDeleteByWasteRecordId(wasteRecordId);

        return ResultDTO.okOf();
    }

    @DeleteMapping("/waste/disposal/delete/{id}")
    @ResponseBody
    public ResultDTO wasteProfileDisposalDelete(@PathVariable(value = "id") Integer wasteRecordId, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (!user.getPermission().equals("disposaler") && !user.getPermission().equals("admin")){
            throw new CustomizeException(CustomizeErrorCode.NO_AUTHORITY);
        }

        wasteService.disposalRecordDeleteByWasteRecordId(wasteRecordId);

        return ResultDTO.okOf();
    }


}
