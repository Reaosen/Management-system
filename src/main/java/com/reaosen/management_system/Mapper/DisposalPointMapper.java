package com.reaosen.management_system.Mapper;

import com.reaosen.management_system.Model.DisposalPoint;
import com.reaosen.management_system.Model.DisposalPointExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface DisposalPointMapper {
    long countByExample(DisposalPointExample example);

    int deleteByExample(DisposalPointExample example);

    int deleteByPrimaryKey(Integer disposalPointId);

    int insert(DisposalPoint record);

    int insertSelective(DisposalPoint record);

    List<DisposalPoint> selectByExampleWithRowbounds(DisposalPointExample example, RowBounds rowBounds);

    List<DisposalPoint> selectByExample(DisposalPointExample example);

    DisposalPoint selectByPrimaryKey(Integer disposalPointId);

    int updateByExampleSelective(@Param("record") DisposalPoint record, @Param("example") DisposalPointExample example);

    int updateByExample(@Param("record") DisposalPoint record, @Param("example") DisposalPointExample example);

    int updateByPrimaryKeySelective(DisposalPoint record);

    int updateByPrimaryKey(DisposalPoint record);
}