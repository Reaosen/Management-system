package com.reaosen.management_system.Controller;

import com.reaosen.management_system.DTO.PaginationDTO;
import com.reaosen.management_system.Model.TransportRecord;
import com.reaosen.management_system.Service.wasteService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public PaginationDTO wasteTransportationPagination(HttpServletRequest request,
                                                       Model model,
                                                       @RequestParam(value = "sEcho") Integer sEcho,
                                                       @RequestParam(value = "iDisplayStart", defaultValue = "0") Integer iDisplayStart,
                                                       @RequestParam(value = "iDisplayLength", defaultValue = "10") Integer iDisplayLength,
                                                       @RequestParam(value = "sSearch", defaultValue = "") String sSearch){

        PaginationDTO pagination = wasteService.wasteTransportationPagination("transportation", sEcho, iDisplayStart, iDisplayLength, sSearch);
        return pagination;
    }

    @GetMapping("/waste/disposal/pagination")
    @ResponseBody
    public PaginationDTO wasteDisposalPagination(HttpServletRequest request,
                                                       Model model,
                                                       @RequestParam(value = "sEcho") Integer sEcho,
                                                       @RequestParam(value = "iDisplayStart", defaultValue = "0") Integer iDisplayStart,
                                                       @RequestParam(value = "iDisplayLength", defaultValue = "10") Integer iDisplayLength,
                                                       @RequestParam(value = "sSearch", defaultValue = "") String sSearch){

        PaginationDTO pagination = wasteService.wasteTransportationPagination("disposal", sEcho, iDisplayStart, iDisplayLength, sSearch);
        return pagination;
    }

    @GetMapping("/waste/collection/pagination")
    @ResponseBody
    public PaginationDTO wasteCollectionPagination(HttpServletRequest request,
                                                       Model model,
                                                       @RequestParam(value = "sEcho") Integer sEcho,
                                                       @RequestParam(value = "iDisplayStart", defaultValue = "0") Integer iDisplayStart,
                                                       @RequestParam(value = "iDisplayLength", defaultValue = "10") Integer iDisplayLength,
                                                       @RequestParam(value = "sSearch", defaultValue = "") String sSearch){

        PaginationDTO pagination = wasteService.wasteTransportationPagination("collection", sEcho, iDisplayStart, iDisplayLength, sSearch);
        return pagination;
    }



}
