package com.reaosen.management_system.Mapper;

import com.reaosen.management_system.Model.TransportRecord;
import com.reaosen.management_system.Model.TransportRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TransportRecordMapper {
    long countByExample(TransportRecordExample example);

    int deleteByExample(TransportRecordExample example);

    int deleteByPrimaryKey(Integer transportid);

    int insert(TransportRecord record);

    int insertSelective(TransportRecord record);

    List<TransportRecord> selectByExampleWithRowbounds(TransportRecordExample example, RowBounds rowBounds);

    List<TransportRecord> selectByExample(TransportRecordExample example);

    TransportRecord selectByPrimaryKey(Integer transportid);

    int updateByExampleSelective(@Param("record") TransportRecord record, @Param("example") TransportRecordExample example);

    int updateByExample(@Param("record") TransportRecord record, @Param("example") TransportRecordExample example);

    int updateByPrimaryKeySelective(TransportRecord record);

    int updateByPrimaryKey(TransportRecord record);
}