package com.reaosen.management_system.Mapper;

import com.reaosen.management_system.Model.WasteRecord;
import com.reaosen.management_system.Model.WasteRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface WasteRecordMapper {
    long countByExample(WasteRecordExample example);

    int deleteByExample(WasteRecordExample example);

    int deleteByPrimaryKey(Integer wasteRecordId);

    int insert(WasteRecord record);

    int insertSelective(WasteRecord record);

    List<WasteRecord> selectByExampleWithRowbounds(WasteRecordExample example, RowBounds rowBounds);

    List<WasteRecord> selectByExample(WasteRecordExample example);

    WasteRecord selectByPrimaryKey(Integer wasteRecordId);

    int updateByExampleSelective(@Param("record") WasteRecord record, @Param("example") WasteRecordExample example);

    int updateByExample(@Param("record") WasteRecord record, @Param("example") WasteRecordExample example);

    int updateByPrimaryKeySelective(WasteRecord record);

    int updateByPrimaryKey(WasteRecord record);
}