package com.reaosen.management_system.Mapper;

import com.reaosen.management_system.Model.StatusType;
import com.reaosen.management_system.Model.StatusTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface StatusTypeMapper {
    long countByExample(StatusTypeExample example);

    int deleteByExample(StatusTypeExample example);

    int deleteByPrimaryKey(Integer statusTypeId);

    int insert(StatusType record);

    int insertSelective(StatusType record);

    List<StatusType> selectByExampleWithRowbounds(StatusTypeExample example, RowBounds rowBounds);

    List<StatusType> selectByExample(StatusTypeExample example);

    StatusType selectByPrimaryKey(Integer statusTypeId);

    int updateByExampleSelective(@Param("record") StatusType record, @Param("example") StatusTypeExample example);

    int updateByExample(@Param("record") StatusType record, @Param("example") StatusTypeExample example);

    int updateByPrimaryKeySelective(StatusType record);

    int updateByPrimaryKey(StatusType record);
}