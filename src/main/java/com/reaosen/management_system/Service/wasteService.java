package com.reaosen.management_system.Service;

import com.reaosen.management_system.DTO.PaginationDTO;

import java.math.BigDecimal;
import java.util.Map;

public interface wasteService {
    PaginationDTO wastePagination(String type, Integer sEcho, Integer iDisplayStart, Integer iDisplayLength, String sSearch);

    Map initCollectionForm();

    void wasteCollectionInsert(Integer wasteTypeId, Integer collectionPointId, BigDecimal weight, Integer collectionAccountId);
}
