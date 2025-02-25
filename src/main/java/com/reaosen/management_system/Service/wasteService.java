package com.reaosen.management_system.Service;

import com.reaosen.management_system.DTO.PaginationDTO;
import com.reaosen.management_system.DTO.StatusTypeDTO;
import com.reaosen.management_system.DTO.WasteDTO;

import java.math.BigDecimal;
import java.util.List;

public interface wasteService {
    PaginationDTO wastePagination(String type, Integer sEcho, Integer iDisplayStart, Integer iDisplayLength, String sSearch);

    void wasteCollectionInsert(Integer wasteTypeId, Integer collectionPointId, BigDecimal weight, Integer collectionAccountId);

    void wasteDisposalInsert(Integer disposalPointId, Integer wasteRecordId, String disposalMethod, Integer collectionAccountId);

    void wasteTransportationInsert(Integer collectionPointId, Integer wasteRecordId, Integer disposalPointId, BigDecimal weight, String transportVehicle, Integer collectionAccountId);

    List getWastesByDisposalPointId(Integer disposalPointId);

    List getWastesByCollectionPointId(Integer collectionPointId);

    WasteDTO getWasteByWasteRecordId(Integer wasteRecordId);

    List getWasteTypes();

    List getCollectionPoints();

    List getDisposalPoints();

    List<StatusTypeDTO> getStatuses();

    List getUsersByRole(String role);

    void wasteRecordUpdate(Integer wasteRecordId, Integer wasteTypeId, BigDecimal weight, Integer collectionPointId, String collectionTime, Integer statusId, Integer collectionAccountId);

    void transportRecordUpdateByWasteRecordId(Integer wasteRecordId, Integer collectionPointId, Integer disposalPointId, String transportTime, String transportVehicle, Integer transportAccountId);

    void disposalRecordUpdateByWasteRecordId(Integer wasteRecordId, String disposalMethod, Integer disposalPointId, String disposalTime, Integer disposalAccountId);
}
