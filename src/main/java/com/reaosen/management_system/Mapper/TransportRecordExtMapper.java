package com.reaosen.management_system.Mapper;

import com.reaosen.management_system.Model.TransportRecord;
import com.reaosen.management_system.Model.WasteRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TransportRecordExtMapper {
    List<TransportRecord> selectDataByTimes(@Param("accountId") Integer accountId, @Param("startTime") Integer startTime, @Param("endTime") Integer endTime);
    Integer countDataByTimes(@Param("accountId") Integer accountId, @Param("startTime") Integer startTime, @Param("endTime") Integer endTime);

}
