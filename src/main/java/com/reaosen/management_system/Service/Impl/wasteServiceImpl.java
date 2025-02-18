package com.reaosen.management_system.Service.Impl;

import com.reaosen.management_system.DTO.PaginationDTO;
import com.reaosen.management_system.DTO.UserDTO;
import com.reaosen.management_system.DTO.WasteDTO;
import com.reaosen.management_system.Mapper.*;
import com.reaosen.management_system.Model.*;
import com.reaosen.management_system.Service.wasteService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class wasteServiceImpl implements wasteService {

    @Autowired
    private TransportRecordMapper transportRecordMapper;

    @Autowired
    private WasteRecordMapper wasteRecordMapper;

    @Autowired
    private WasteTypeMapper wasteTypeMapper;

    @Autowired
    private CollectionPointMapper collectionPointMapper;

    @Autowired
    private DisposalPointMapper disposalPointMapper;

    @Override
    public PaginationDTO wasteTransportationPagination(Integer sEcho, Integer iDisplayStart, Integer iDisplayLength, String sSearch) {
        // 获取总记录数（不考虑搜索条件）
        Long totalRecords = transportRecordMapper.countByExample(new TransportRecordExample());

        // 根据搜索条件构建 Example
        TransportRecordExample transportRecordExample = new TransportRecordExample();
        if (sSearch != null && !sSearch.trim().isEmpty()) {
            // 创建第一个条件
            TransportRecordExample.Criteria criteria1 = transportRecordExample.createCriteria();
            criteria1.andTransportusernameLike("%" + sSearch + "%");

            // 创建第二个条件
            TransportRecordExample.Criteria criteria2 = transportRecordExample.or();
            criteria2.andTransportVehicleLike("%" + sSearch + "%");
        }

        // 获取筛选后的记录数
        Long totalFiltered = transportRecordMapper.countByExample(transportRecordExample);

        // 计算分页的 offset
        int offset = iDisplayStart == null ? 0 : iDisplayStart;
        int size = iDisplayLength == null ? 10 : iDisplayLength;

        // 获取当前页的数据
        transportRecordExample.setOrderByClause("gmt_create desc");
        List<TransportRecord> transportRecords = transportRecordMapper.selectByExampleWithRowbounds(transportRecordExample, new RowBounds(offset, size));
        List<WasteDTO> wasteDTOs = new ArrayList<>();
        for (TransportRecord transportRecord : transportRecords) {
            WasteDTO wasteDTO = new WasteDTO();
            BeanUtils.copyProperties(transportRecord, wasteDTO);

            WasteRecord wasteRecord = wasteRecordMapper.selectByPrimaryKey(transportRecord.getWasteRecordId());
            WasteType wasteType = wasteTypeMapper.selectByPrimaryKey(wasteRecord.getWasteTypeId());
            CollectionPoint collectionPoint = collectionPointMapper.selectByPrimaryKey(wasteRecord.getCollectionPointId());
            DisposalPoint disposalPoint = disposalPointMapper.selectByPrimaryKey(transportRecord.getDisposalPointId());


            wasteDTO.setWasteType(wasteType.getTypeName());
            wasteDTO.setWeight(wasteRecord.getWeight());
            wasteDTO.setCollectionPoint(collectionPoint.getAddress());
            wasteDTO.setDisposalPoint(disposalPoint.getAddress());

            wasteDTOs.add(wasteDTO);
        }
        // 构造返回的 DTO
        PaginationDTO<WasteDTO> Pagination = new PaginationDTO<>();
        Pagination.setSEcho(sEcho); // DataTables 请求的次数
        Pagination.setITotalRecords(totalRecords);
        Pagination.setITotalDisplayRecords(totalFiltered);
        Pagination.setAaData(wasteDTOs);

        return Pagination;
    }

}
