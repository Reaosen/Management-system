package com.reaosen.management_system.Mapper;

import com.reaosen.management_system.Model.WasteRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WasteRecordExtMapper {
    List<WasteRecord> selectDataByAccountIdAndTimes(@Param("accountId") Integer accountId, @Param("startTime") Integer startTime, @Param("endTime") Integer endTime);
    List<WasteRecord> selectDataByTimes(@Param("startTime") Integer startTime, @Param("endTime") Integer endTime);
    Integer countDataByAccountIdAndTimes(@Param("accountId") Integer accountId, @Param("startTime") Integer startTime, @Param("endTime") Integer endTime);
    Integer countDataByTimes(@Param("startTime") Integer startTime, @Param("endTime") Integer endTime);
}
