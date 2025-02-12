package com.reaosen.management_system.Mapper;

import com.reaosen.management_system.Model.DisposalRecord;
import com.reaosen.management_system.Model.DisposalRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface DisposalRecordMapper {
    long countByExample(DisposalRecordExample example);

    int deleteByExample(DisposalRecordExample example);

    int deleteByPrimaryKey(Integer disposalid);

    int insert(DisposalRecord record);

    int insertSelective(DisposalRecord record);

    List<DisposalRecord> selectByExampleWithRowbounds(DisposalRecordExample example, RowBounds rowBounds);

    List<DisposalRecord> selectByExample(DisposalRecordExample example);

    DisposalRecord selectByPrimaryKey(Integer disposalid);

    int updateByExampleSelective(@Param("record") DisposalRecord record, @Param("example") DisposalRecordExample example);

    int updateByExample(@Param("record") DisposalRecord record, @Param("example") DisposalRecordExample example);

    int updateByPrimaryKeySelective(DisposalRecord record);

    int updateByPrimaryKey(DisposalRecord record);
}