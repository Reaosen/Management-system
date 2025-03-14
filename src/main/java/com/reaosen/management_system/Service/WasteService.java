package com.reaosen.management_system.Service;

import com.reaosen.management_system.DTO.*;

import java.math.BigDecimal;
import java.util.List;

public interface WasteService {
    PaginationDTO wastePagination(String type, Integer sEcho, Integer iDisplayStart, Integer iDisplayLength, String sSearch);

    public PaginationDTO wastePaginationByStatus(String type, Integer STATUS, Integer sEcho, Integer iDisplayStart, Integer iDisplayLength, String sSearch);

    public PaginationDTO wastePaginationByPayStatus(String type, Integer payStatus, Integer sEcho, Integer iDisplayStart, Integer iDisplayLength, String sSearch);

    void wasteCollectionInsert(Integer wasteTypeId, Integer collectionPointId, BigDecimal weight, Integer collectionAccountId);

    void wasteDisposalInsert(Integer disposalPointId, Integer wasteRecordId, Integer disposalMethod, BigDecimal budget, Integer collectionAccountId);

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

    void disposalRecordUpdateByWasteRecordId(Integer wasteRecordId, Integer disposalMethod, BigDecimal budget, Integer disposalPointId, String disposalTime, Integer disposalAccountId);

    void wasteRecordDelete(Integer wasteRecordId);

    void transportRecordDeleteByWasteRecordId(Integer wasteRecordId);

    void disposalRecordDeleteByWasteRecordId(Integer wasteRecordId);

    PaginationDTO employeeWorkPagination(Integer sEcho, Integer iDisplayStart, Integer iDisplayLength, String sSearch);

    Integer getWorkTotalByTypeAndAccountId(String type, Integer accountId);

    List<WasteDTO> getWorkDataByTypeAndAccountId(String type, Integer accountId);

    Integer getWasteTotalByTime(String timeType, String dataType);

    List<PieChartDataDTO> getWasteTypeDistribute();

    LineChartDataDTO getWeekDataByType(String timeType);

    String getWOWdataByType(String type);

    LineChartDataDTO getWasteDataByMonth(Integer year, Integer month);

    List getMainWasteCollectionPoints();

    List getMainDisposalMethods();

    List getDisposalMethods();

    List<PieChartDataDTO> getCollectionPointsDataByMonth(Integer year, Integer month);

    List<PieChartDataDTO> getDisposalMethodsDataByMonth(Integer year, Integer month);

    DrilldownBarChartDTO getInitialQuarterData();

    DrilldownBarChartDTO getDrilldownInitialQuarterData(String groupId);

    String getmainQuarter();

    List<WasteDTO> getUnfinishedTransportTask();

    Integer getTransportTaskProportion();

    List<PieChartDataDTO> getDisposalPointDistribute();

    List<WasteDTO> getUnfinishedDisposalTask();

    Integer getDisposalTaskProportion();

    Integer getUsedCapacityProportion(Integer regionId);

    List<WasteTypesCapacityDTO> getWasteTypesCapacityProportion(Integer regionId);

    List getBudgetsThisYear();

    Integer getWastesCountByStatus(Integer type);

    Integer getUnPaidWastesCount();

    BigDecimal getStorageCapacity();

    void payForDisposal(Integer id);

    List getWastesUndisposal();
}
