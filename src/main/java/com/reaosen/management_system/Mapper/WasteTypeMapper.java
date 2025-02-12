package com.reaosen.management_system.Mapper;

import com.reaosen.management_system.Model.WasteType;
import com.reaosen.management_system.Model.WasteTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface WasteTypeMapper {
    long countByExample(WasteTypeExample example);

    int deleteByExample(WasteTypeExample example);

    int deleteByPrimaryKey(Integer wastetypeid);

    int insert(WasteType record);

    int insertSelective(WasteType record);

    List<WasteType> selectByExampleWithBLOBsWithRowbounds(WasteTypeExample example, RowBounds rowBounds);

    List<WasteType> selectByExampleWithBLOBs(WasteTypeExample example);

    List<WasteType> selectByExampleWithRowbounds(WasteTypeExample example, RowBounds rowBounds);

    List<WasteType> selectByExample(WasteTypeExample example);

    WasteType selectByPrimaryKey(Integer wastetypeid);

    int updateByExampleSelective(@Param("record") WasteType record, @Param("example") WasteTypeExample example);

    int updateByExampleWithBLOBs(@Param("record") WasteType record, @Param("example") WasteTypeExample example);

    int updateByExample(@Param("record") WasteType record, @Param("example") WasteTypeExample example);

    int updateByPrimaryKeySelective(WasteType record);

    int updateByPrimaryKeyWithBLOBs(WasteType record);

    int updateByPrimaryKey(WasteType record);
}