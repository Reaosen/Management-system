package com.reaosen.management_system.Mapper;

import com.reaosen.management_system.Model.DisposalMethod;
import com.reaosen.management_system.Model.DisposalMethodExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface DisposalMethodMapper {
    long countByExample(DisposalMethodExample example);

    int deleteByExample(DisposalMethodExample example);

    int deleteByPrimaryKey(Integer disposalMethodId);

    int insert(DisposalMethod record);

    int insertSelective(DisposalMethod record);

    List<DisposalMethod> selectByExampleWithRowbounds(DisposalMethodExample example, RowBounds rowBounds);

    List<DisposalMethod> selectByExample(DisposalMethodExample example);

    DisposalMethod selectByPrimaryKey(Integer disposalMethodId);

    int updateByExampleSelective(@Param("record") DisposalMethod record, @Param("example") DisposalMethodExample example);

    int updateByExample(@Param("record") DisposalMethod record, @Param("example") DisposalMethodExample example);

    int updateByPrimaryKeySelective(DisposalMethod record);

    int updateByPrimaryKey(DisposalMethod record);
}