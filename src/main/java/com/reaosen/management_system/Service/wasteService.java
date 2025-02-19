package com.reaosen.management_system.Service;

import com.reaosen.management_system.DTO.PaginationDTO;

public interface wasteService {
    PaginationDTO wasteTransportationPagination(String type, Integer sEcho, Integer iDisplayStart, Integer iDisplayLength, String sSearch);

}
