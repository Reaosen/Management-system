package com.reaosen.management_system.Service.Impl;

import cn.hutool.core.date.DateUtil;
import com.reaosen.management_system.DTO.*;
import com.reaosen.management_system.Mapper.*;
import com.reaosen.management_system.Model.*;
import com.reaosen.management_system.Service.wasteService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @Autowired
    private DisposalRecordMapper disposalRecordMapper;

    @Autowired
    private UserMapper userMapper;


    @Override
    public PaginationDTO wastePagination(String type, Integer sEcho, Integer iDisplayStart, Integer iDisplayLength, String sSearch) {
        // 获取总记录数（不考虑搜索条件）
        Long totalRecords = getTotalRecords(type);
        Long totalFiltered;

        // 计算分页的 offset
        int offset = iDisplayStart == null ? 0 : iDisplayStart;
        int size = iDisplayLength == null ? 10 : iDisplayLength;

        // 根据搜索条件构建 Example
        WasteRecordExample wasteRecordExample = new WasteRecordExample();
        TransportRecordExample transportRecordExample = new TransportRecordExample();
        DisposalRecordExample disposalRecordExample = new DisposalRecordExample();

        ArrayList<Integer> searchs = new ArrayList<>();
        //TODO 搜索框未完成
        if (type.equals("transportation")) {
            WasteRecordExample.Criteria criteria = wasteRecordExample.createCriteria();
            criteria.andStatusBetween(2, 3);
            if (sSearch != null && !sSearch.trim().isEmpty()) {
                // 创建第一个条件
                TransportRecordExample.Criteria criteria1 = transportRecordExample.createCriteria();
                criteria1.andTransportusernameLike("%" + sSearch + "%");

                // 创建第二个条件
                TransportRecordExample.Criteria criteria2 = transportRecordExample.or();
                criteria2.andTransportVehicleLike("%" + sSearch + "%");
            }
            List<TransportRecord> transportRecords = transportRecordMapper.selectByExampleWithRowbounds(transportRecordExample, new RowBounds(offset, size));
            for (TransportRecord transportRecord : transportRecords) {
                searchs.add(transportRecord.getWasteRecordId());
            }
            // 获取筛选后的记录数
            totalFiltered = transportRecordMapper.countByExample(transportRecordExample);
        } else if (type.equals("disposal")) {
            WasteRecordExample.Criteria criteria = wasteRecordExample.createCriteria();
            criteria.andStatusEqualTo(3);
            if (sSearch != null && !sSearch.trim().isEmpty()) {
                // 创建第一个条件
                DisposalRecordExample.Criteria criteria1 = disposalRecordExample.createCriteria();
                criteria1.andDisposalMethodLike("%" + sSearch + "%");
            }
            List<DisposalRecord> disposalRecords = disposalRecordMapper.selectByExampleWithRowbounds(disposalRecordExample, new RowBounds(offset, size));
            for (DisposalRecord disposalRecord : disposalRecords) {
                searchs.add(disposalRecord.getWasteRecordId());
            }
            totalFiltered = disposalRecordMapper.countByExample(disposalRecordExample);
        } else {
            List<WasteRecord> wasteRecords = wasteRecordMapper.selectByExample(wasteRecordExample);
            for (WasteRecord wasteRecord : wasteRecords) {
                searchs.add(wasteRecord.getWasteRecordId());
            }
            totalFiltered = wasteRecordMapper.countByExample(wasteRecordExample);
        }


        // 获取当前页的数据
        wasteRecordExample.setOrderByClause("gmt_create desc");
        List<WasteRecord> wasteRecords = wasteRecordMapper.selectByExampleWithRowbounds(wasteRecordExample, new RowBounds(offset, size));
        List<WasteDTO> wasteDTOs = new ArrayList<>();
        for (WasteRecord wasteRecord : wasteRecords) {
            WasteDTO wasteDTO = new WasteDTO();
            BeanUtils.copyProperties(wasteRecord, wasteDTO);
            Integer status = wasteRecord.getStatus();
            //收集信息获取
            WasteType wasteType = wasteTypeMapper.selectByPrimaryKey(wasteRecord.getWasteTypeId());
            CollectionPoint collectionPoint = collectionPointMapper.selectByPrimaryKey(wasteRecord.getCollectionPointId());

            wasteDTO.setWasteType(wasteType.getTypeName());
            wasteDTO.setWeight(wasteRecord.getWeight());
            wasteDTO.setCollectionPoint(collectionPoint.getAddress());
            if (wasteRecord.getStatus() == 1) {
                wasteDTO.setStatus("已收集");
            } else if (wasteRecord.getStatus() == 2) {
                wasteDTO.setStatus("已运输");
            } else {
                wasteDTO.setStatus("已处理");
            }
            Long collectionTimestamp = Long.valueOf(wasteRecord.getCollectionTime());
            wasteDTO.setCollectionTime(DateUtil.format(DateUtil.date(collectionTimestamp * 1000), "yyyy-MM-dd HH:mm:ss"));
            UserExample userExample1 = new UserExample();
            userExample1.createCriteria().andAccountIdEqualTo(wasteRecord.getCollectionAccountId());
            List<User> users1 = userMapper.selectByExample(userExample1);
            wasteDTO.setCollectionusername(users1.get(0).getUsername());
            //运输信息获取
            if (status != 1) {
                TransportRecordExample transportRecordExample1 = new TransportRecordExample();
                transportRecordExample1.createCriteria().andWasteRecordIdEqualTo(wasteRecord.getWasteRecordId());
                List<TransportRecord> transportRecords = transportRecordMapper.selectByExample(transportRecordExample1);
                TransportRecord transportRecord = transportRecords.get(0);

                wasteDTO.setTransportId(transportRecord.getTransportId());
                Long transportTimestamp = Long.valueOf(transportRecord.getTransportTime());
                wasteDTO.setTransportTime(DateUtil.format(DateUtil.date(transportTimestamp * 1000), "yyyy-MM-dd HH:mm:ss"));
                wasteDTO.setTransportVehicle(transportRecord.getTransportVehicle());
                wasteDTO.setTransportusername(transportRecord.getTransportusername());

                DisposalPoint disposalPoint = disposalPointMapper.selectByPrimaryKey(transportRecord.getDisposalPointId());
                wasteDTO.setDisposalPoint(disposalPoint.getAddress());
                if (status == 3) {
                    DisposalRecordExample disposalRecordExample1 = new DisposalRecordExample();
                    disposalRecordExample1.createCriteria().andWasteRecordIdEqualTo(wasteRecord.getWasteRecordId());
                    List<DisposalRecord> disposalRecords = disposalRecordMapper.selectByExample(disposalRecordExample1);
                    DisposalRecord disposalRecord = disposalRecords.get(0);

                    wasteDTO.setDisposalId(disposalRecord.getDisposalId());

                    UserExample userExample2 = new UserExample();
                    userExample2.createCriteria().andAccountIdEqualTo(disposalRecord.getDisposalAccountId());
                    List<User> users2 = userMapper.selectByExample(userExample2);
                    wasteDTO.setDisposalusername(users2.get(0).getUsername());
                    Long disposalTimestamp = Long.valueOf(disposalRecord.getDisposalTime());
                    wasteDTO.setDisposalTime(DateUtil.format(DateUtil.date(disposalTimestamp * 1000), "yyyy-MM-dd HH:mm:ss"));
                    wasteDTO.setDisposalMethod(disposalRecord.getDisposalMethod());
                }
            }


            if (searchs.contains(wasteRecord.getWasteRecordId())) {
                wasteDTOs.add(wasteDTO);
            }
        }
        // 构造返回的 DTO
        PaginationDTO<WasteDTO> Pagination = new PaginationDTO<>();
        Pagination.setSEcho(sEcho); // DataTables 请求的次数
        Pagination.setITotalRecords(totalRecords);
        Pagination.setITotalDisplayRecords(totalFiltered);
        Pagination.setAaData(wasteDTOs);

        return Pagination;
    }

    @Override
    public Map initCollectionForm() {
        List<WasteType> wasteTypes = wasteTypeMapper.selectByExample(new WasteTypeExample());
        List<WasteTypeDTO> wasteTypeDTOLists = new ArrayList<>();
        for (WasteType wasteType : wasteTypes) {
            WasteTypeDTO wasteTypeDTO = new WasteTypeDTO();
            BeanUtils.copyProperties(wasteType, wasteTypeDTO);
            wasteTypeDTOLists.add(wasteTypeDTO);
        }

        List<CollectionPoint> collectionPoints = collectionPointMapper.selectByExample(new CollectionPointExample());
        List<CollectionPointDTO> collectionPointDTOLists = new ArrayList<>();
        for (CollectionPoint collectionPoint : collectionPoints) {
            CollectionPointDTO collectionPointDTO = new CollectionPointDTO();
            BeanUtils.copyProperties(collectionPoint, collectionPointDTO);
            collectionPointDTOLists.add(collectionPointDTO);
        }

        Map<String, List> result = new HashMap<>();
        result.put("wasteTypes", wasteTypeDTOLists);
        result.put("collectionPoints", collectionPointDTOLists);

        return result;
    }

    @Override
    public void wasteCollectionInsert(Integer wasteTypeId, Integer collectionPointId, BigDecimal weight, Integer collectionAccountId) {
        WasteRecord record = new WasteRecord();
        record.setStatus(1);
        record.setCollectionAccountId(collectionAccountId);
        record.setCollectionPointId(collectionPointId);
        record.setWasteTypeId(wasteTypeId);
        record.setWeight(weight);
        //TODO 时间修改
        long timeStepMillis = System.currentTimeMillis();
        Integer timeStep = Math.toIntExact(timeStepMillis / 1000);
        record.setCollectionTime(timeStep);
        wasteRecordMapper.insert(record);
    }

    @Override
    public List<DisposalPointDTO> initDisposalForm() {
        // 查询所有处置点
        List<DisposalPoint> disposalPoints = disposalPointMapper.selectByExample(new DisposalPointExample());
        List<DisposalPointDTO> disposalPointDTOs = new ArrayList<>();
        for (DisposalPoint disposalPoint : disposalPoints) {
            DisposalPointDTO disposalPointDTO = new DisposalPointDTO();
            BeanUtils.copyProperties(disposalPoint, disposalPointDTO);
            disposalPointDTOs.add(disposalPointDTO);
        }

        return disposalPointDTOs;
    }

    @Override
    public List wasteDisposalFormSecondaryMenu(Integer disposalPointId) {
        TransportRecordExample example = new TransportRecordExample();
        example.createCriteria().andDisposalPointIdEqualTo(disposalPointId);
        List<TransportRecord> transportRecords = transportRecordMapper.selectByExample(example);
        List<WasteDTO> wasteDTOs = new ArrayList<>();
        for (TransportRecord transportRecord : transportRecords) {
            WasteRecord wasteRecord = wasteRecordMapper.selectByPrimaryKey(transportRecord.getWasteRecordId());
            if (wasteRecord.getStatus() == 3) continue;
            WasteDTO wasteDTO = new WasteDTO();
            BeanUtils.copyProperties(transportRecord, wasteDTO);
            wasteDTOs.add(wasteDTO);
        }
        return wasteDTOs;
    }

    @Override
    public void wasteDisposalInsert(Integer disposalPointId, Integer wasteRecordId, String disposalMethod, Integer collectionAccountId) {
        DisposalRecord record = new DisposalRecord();
        record.setWasteRecordId(wasteRecordId);
        record.setDisposalAccountId(collectionAccountId);
        record.setDisposalPointId(disposalPointId);
        record.setDisposalMethod(disposalMethod);
        //TODO 时间修改
        long timeStepMillis = System.currentTimeMillis();
        Integer timeStep = Math.toIntExact(timeStepMillis / 1000);
        record.setDisposalTime(timeStep);

        WasteRecord wasteRecord = wasteRecordMapper.selectByPrimaryKey(wasteRecordId);
        wasteRecord.setStatus(3);
        wasteRecordMapper.updateByPrimaryKeySelective(wasteRecord);

        disposalRecordMapper.insert(record);
    }

    @Override
    public Map initTransportationForm() {
        List<CollectionPoint> collectionPoints = collectionPointMapper.selectByExample(new CollectionPointExample());
        List<CollectionPointDTO> collectionPointDTOs = new ArrayList<>();
        for (CollectionPoint collectionPoint : collectionPoints) {
            CollectionPointDTO collectionPointDTO = new CollectionPointDTO();
            BeanUtils.copyProperties(collectionPoint, collectionPointDTO);
            collectionPointDTOs.add(collectionPointDTO);
        }
        List<DisposalPoint> disposalPoints = disposalPointMapper.selectByExample(new DisposalPointExample());
        List<DisposalPointDTO> disposalPointDTOs = new ArrayList<>();
        for (DisposalPoint disposalPoint : disposalPoints) {
            DisposalPointDTO disposalPointDTO = new DisposalPointDTO();
            BeanUtils.copyProperties(disposalPoint, disposalPointDTO);
            disposalPointDTOs.add(disposalPointDTO);
        }
        Map<String, List> result = new HashMap<>();
        result.put("collectionPoints", collectionPointDTOs);
        result.put("disposalPoints", disposalPointDTOs);

        return result;
    }

    @Override
    public List wasteTransportationFormSecondaryMenu(Integer collectionPointId) {
        WasteRecordExample example = new WasteRecordExample();
        example.createCriteria()
                .andCollectionPointIdEqualTo(collectionPointId)
                .andStatusEqualTo(1);
        List<WasteRecord> wasteRecords = wasteRecordMapper.selectByExample(example);
        List<WasteDTO> wasteDTOs = new ArrayList<>();
        for (WasteRecord wasteRecord : wasteRecords) {
            //TODO 详细信息
            WasteDTO wasteDTO = new WasteDTO();
            BeanUtils.copyProperties(wasteRecord, wasteDTO);
            wasteDTOs.add(wasteDTO);
        }

        return wasteDTOs;
    }

    @Override
    public void wasteTransportationInsert(Integer collectionPointId, Integer wasteRecordId, Integer disposalPointId, BigDecimal weight, String transportVehicle, Integer collectionAccountId) {
        TransportRecord record = new TransportRecord();
        record.setWasteRecordId(wasteRecordId);
        record.setDisposalPointId(disposalPointId);
        record.setCollectionPointId(collectionPointId);
        record.setTransportVehicle(transportVehicle);
        record.setTransportAccountId(collectionAccountId);

        UserExample userExample = new UserExample();
        userExample.createCriteria()
                        .andAccountIdEqualTo(collectionAccountId);
        List<User> users = userMapper.selectByExample(userExample);
        User user = users.get(0);
        record.setTransportusername(user.getUsername());

        //TODO 时间修改
        long timeStepMillis = System.currentTimeMillis();
        Integer timeStep = Math.toIntExact(timeStepMillis / 1000);
        record.setTransportTime(timeStep);
        transportRecordMapper.insertSelective(record);

        WasteRecord wasteRecord = wasteRecordMapper.selectByPrimaryKey(wasteRecordId);
        wasteRecord.setStatus(2);
        wasteRecordMapper.updateByPrimaryKeySelective(wasteRecord);
    }

    private Long getTotalRecords(String type) {
        switch (type) {
            case "collection":
                return wasteRecordMapper.countByExample(new WasteRecordExample());
            case "transportation":
                return transportRecordMapper.countByExample(new TransportRecordExample());
            case "disposal":
                return disposalRecordMapper.countByExample(new DisposalRecordExample());
            default:
                throw new IllegalArgumentException("Invalid type: " + type);
        }
    }



}
