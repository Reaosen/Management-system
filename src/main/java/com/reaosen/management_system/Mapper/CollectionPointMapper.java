package com.reaosen.management_system.Mapper;

import com.reaosen.management_system.Model.CollectionPoint;
import com.reaosen.management_system.Model.CollectionPointExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CollectionPointMapper {
    long countByExample(CollectionPointExample example);

    int deleteByExample(CollectionPointExample example);

    int deleteByPrimaryKey(Integer collectionPointId);

    int insert(CollectionPoint record);

    int insertSelective(CollectionPoint record);

    List<CollectionPoint> selectByExampleWithRowbounds(CollectionPointExample example, RowBounds rowBounds);

    List<CollectionPoint> selectByExample(CollectionPointExample example);

    CollectionPoint selectByPrimaryKey(Integer collectionPointId);

    int updateByExampleSelective(@Param("record") CollectionPoint record, @Param("example") CollectionPointExample example);

    int updateByExample(@Param("record") CollectionPoint record, @Param("example") CollectionPointExample example);

    int updateByPrimaryKeySelective(CollectionPoint record);

    int updateByPrimaryKey(CollectionPoint record);
}