package com.reaosen.management_system.Service.Impl;

import cn.hutool.core.date.DateUtil;
import com.reaosen.management_system.DTO.*;
import com.reaosen.management_system.Exception.CustomizeErrorCode;
import com.reaosen.management_system.Exception.CustomizeException;
import com.reaosen.management_system.Mapper.*;
import com.reaosen.management_system.Model.*;
import com.reaosen.management_system.Service.WasteService;
import com.reaosen.management_system.Utils.TimeUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.util.*;

@Service
public class WasteServiceImpl implements WasteService {

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

    @Autowired
    private StatusTypeMapper statusTypeMapper;

    @Autowired
    private DisposalMethodMapper disposalMethodMapper;

    @Autowired
    private WasteRecordExtMapper wasteRecordExtMapper;
    @Autowired
    private TransportRecordExtMapper transportRecordExtMapper;
    @Autowired
    private DisposalRecordExtMapper disposalRecordExtMapper;


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
        // TODO 搜索框未完成
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
                // DisposalRecordExample.Criteria criteria1 = disposalRecordExample.createCriteria();
                // criteria1.andDisposalMethodLike("%" + sSearch + "%");
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
            // 收集信息获取
            WasteType wasteType = wasteTypeMapper.selectByPrimaryKey(wasteRecord.getWasteTypeId());
            CollectionPoint collectionPoint = collectionPointMapper.selectByPrimaryKey(wasteRecord.getCollectionPointId());
            StatusType statusType = statusTypeMapper.selectByPrimaryKey(wasteRecord.getStatus());


            wasteDTO.setWasteType(wasteType.getTypeName());
            wasteDTO.setWeight(wasteRecord.getWeight());
            wasteDTO.setCollectionPoint(collectionPoint.getAddress());
            wasteDTO.setStatus(statusType.getStatusTypeName());
            Long collectionTimestamp = Long.valueOf(wasteRecord.getCollectionTime());
            wasteDTO.setCollectionTime(DateUtil.format(DateUtil.date(collectionTimestamp * 1000), "yyyy-MM-dd HH:mm:ss"));
            UserExample userExample1 = new UserExample();
            userExample1.createCriteria().andAccountIdEqualTo(wasteRecord.getCollectionAccountId());
            List<User> users1 = userMapper.selectByExample(userExample1);
            wasteDTO.setCollectionusername(users1.get(0).getUsername());
            // 运输信息获取
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

                    DisposalMethod disposalMethod = disposalMethodMapper.selectByPrimaryKey(disposalRecord.getDisposalMethodId());
                    wasteDTO.setDisposalMethod(disposalMethod.getDisposalMethodName());
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
    public List getWasteTypes() {
        List<WasteType> wasteTypes = wasteTypeMapper.selectByExample(new WasteTypeExample());
        List<WasteTypeDTO> wasteTypeDTOLists = new ArrayList<>();
        for (WasteType wasteType : wasteTypes) {
            WasteTypeDTO wasteTypeDTO = new WasteTypeDTO();
            BeanUtils.copyProperties(wasteType, wasteTypeDTO);
            wasteTypeDTOLists.add(wasteTypeDTO);
        }
        return wasteTypeDTOLists;
    }

    @Override
    public List getCollectionPoints() {
        List<CollectionPoint> collectionPoints = collectionPointMapper.selectByExample(new CollectionPointExample());
        List<CollectionPointDTO> collectionPointDTOLists = new ArrayList<>();
        for (CollectionPoint collectionPoint : collectionPoints) {
            CollectionPointDTO collectionPointDTO = new CollectionPointDTO();
            BeanUtils.copyProperties(collectionPoint, collectionPointDTO);
            collectionPointDTOLists.add(collectionPointDTO);
        }
        return collectionPointDTOLists;
    }


    @Override
    public void wasteCollectionInsert(Integer wasteTypeId, Integer collectionPointId, BigDecimal weight, Integer collectionAccountId) {
        WasteRecord record = new WasteRecord();
        record.setStatus(1);
        record.setCollectionAccountId(collectionAccountId);
        record.setCollectionPointId(collectionPointId);
        record.setWasteTypeId(wasteTypeId);
        record.setWeight(weight);
        long timeMillis = System.currentTimeMillis();
        Integer timestamp = Math.toIntExact(timeMillis / 1000);
        // 收集时间
        record.setCollectionTime(timestamp);
        // TODO 公共字段填充-时间
        record.setGmtCreate(timestamp);
        record.setGmtModified(timestamp);
        wasteRecordMapper.insert(record);
    }

    @Override
    public List getDisposalPoints() {
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
    public List getWastesByDisposalPointId(Integer disposalPointId) {
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
    public void wasteDisposalInsert(Integer disposalPointId, Integer wasteRecordId, Integer disposalMethodId, Integer collectionAccountId) {
        DisposalRecord record = new DisposalRecord();
        record.setWasteRecordId(wasteRecordId);
        record.setDisposalAccountId(collectionAccountId);
        record.setDisposalPointId(disposalPointId);
        record.setDisposalMethodId(disposalMethodId);
        long timeMillis = System.currentTimeMillis();
        Integer timestamp = Math.toIntExact(timeMillis / 1000);
        // 处理时间
        record.setDisposalTime(timestamp);

        WasteRecord wasteRecord = wasteRecordMapper.selectByPrimaryKey(wasteRecordId);
        wasteRecord.setStatus(3);
        // TODO 公共字段填充-时间
        wasteRecord.setGmtModified(timestamp);
        record.setGmtModified(timestamp);
        record.setGmtCreate(timestamp);


        wasteRecordMapper.updateByPrimaryKeySelective(wasteRecord);
        disposalRecordMapper.insert(record);
    }


    public List getWastesByCollectionPointId(Integer collectionPointId) {
        WasteRecordExample example = new WasteRecordExample();
        example.createCriteria()
                .andCollectionPointIdEqualTo(collectionPointId)
                .andStatusEqualTo(1);
        List<WasteRecord> wasteRecords = wasteRecordMapper.selectByExample(example);
        List<WasteDTO> wasteDTOs = new ArrayList<>();
        for (WasteRecord wasteRecord : wasteRecords) {
            // TODO 详细信息
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


        long timeMillis = System.currentTimeMillis();
        Integer timeStamp = Math.toIntExact(timeMillis / 1000);
        // 运输时间
        record.setTransportTime(timeStamp);

        WasteRecord wasteRecord = wasteRecordMapper.selectByPrimaryKey(wasteRecordId);
        wasteRecord.setStatus(2);

        // TODO 公共字段填充-时间

        wasteRecord.setGmtModified(timeStamp);
        record.setGmtModified(timeStamp);
        record.setGmtCreate(timeStamp);

        transportRecordMapper.insertSelective(record);
        wasteRecordMapper.updateByPrimaryKeySelective(wasteRecord);
    }

    @Override
    public WasteDTO getWasteByWasteRecordId(Integer wasteRecordId) {
        WasteRecord wasteRecord = wasteRecordMapper.selectByPrimaryKey(wasteRecordId);
        CollectionPoint collectionPoint = collectionPointMapper.selectByPrimaryKey(wasteRecord.getCollectionPointId());
        WasteType wasteType = wasteTypeMapper.selectByPrimaryKey(wasteRecord.getWasteTypeId());
        WasteDTO wasteDTO = new WasteDTO();
        BeanUtils.copyProperties(wasteRecord, wasteDTO);
        wasteDTO.setCollectionPoint(collectionPoint.getAddress());
        wasteDTO.setStatusId(wasteRecord.getStatus());
        wasteDTO.setWasteType(wasteType.getTypeName());

        Long collectionTimestamp = Long.valueOf(wasteRecord.getCollectionTime());
        wasteDTO.setCollectionTime(DateUtil.format(DateUtil.date(collectionTimestamp * 1000), "yyyy-MM-dd HH:mm:ss"));

        UserExample collectionUserExample = new UserExample();
        collectionUserExample.createCriteria()
                .andAccountIdEqualTo(wasteRecord.getCollectionAccountId());
        List<User> collectionUsers = userMapper.selectByExample(collectionUserExample);
        User collectionUser = collectionUsers.get(0);
        wasteDTO.setCollectionusername(collectionUser.getUsername());

        if (wasteRecord.getStatus() != 1) {
            TransportRecordExample transportRecordExample = new TransportRecordExample();
            transportRecordExample.createCriteria()
                    .andWasteRecordIdEqualTo(wasteRecordId);
            List<TransportRecord> transportRecords = transportRecordMapper.selectByExample(transportRecordExample);
            TransportRecord transportRecord = transportRecords.get(0);
            wasteDTO.setTransportId(transportRecord.getTransportId());
            wasteDTO.setTransportusername(transportRecord.getTransportusername());

            Long transportTimestamp = Long.valueOf(transportRecord.getTransportTime());
            wasteDTO.setTransportTime(DateUtil.format(DateUtil.date(transportTimestamp * 1000), "yyyy-MM-dd HH:mm:ss"));

            wasteDTO.setTransportVehicle(transportRecord.getTransportVehicle());

            if (wasteRecord.getStatus() == 3) {
                DisposalRecordExample disposalRecordExample = new DisposalRecordExample();
                disposalRecordExample.createCriteria()
                        .andWasteRecordIdEqualTo(wasteRecordId);
                List<DisposalRecord> disposalRecords = disposalRecordMapper.selectByExample(disposalRecordExample);
                DisposalRecord disposalRecord = disposalRecords.get(0);
                DisposalPoint disposalPoint = disposalPointMapper.selectByPrimaryKey(disposalRecord.getDisposalPointId());
                wasteDTO.setDisposalId(disposalRecord.getDisposalId());
                UserExample disposalUserExample = new UserExample();
                disposalUserExample.createCriteria()
                        .andAccountIdEqualTo(disposalRecord.getDisposalAccountId());
                List<User> disposalUsers = userMapper.selectByExample(disposalUserExample);
                User disposalUser = disposalUsers.get(0);
                wasteDTO.setDisposalusername(disposalUser.getUsername());
                DisposalMethod disposalMethod = disposalMethodMapper.selectByPrimaryKey(disposalRecord.getDisposalMethodId());
                wasteDTO.setDisposalMethod(disposalMethod.getDisposalMethodName());
                wasteDTO.setDisposalPoint(disposalPoint.getAddress());

                Long disposalTimestamp = Long.valueOf(disposalRecord.getDisposalTime());
                wasteDTO.setDisposalTime(DateUtil.format(DateUtil.date(disposalTimestamp * 1000), "yyyy-MM-dd HH:mm:ss"));

            }

        }

        return wasteDTO;
    }

    @Override
    public List<StatusTypeDTO> getStatuses() {
        List<StatusType> statusTypes = statusTypeMapper.selectByExample(new StatusTypeExample());
        List statusTypeDTOs = new ArrayList();
        for (StatusType statusType : statusTypes) {
            StatusTypeDTO statusTypeDTO = new StatusTypeDTO();
            BeanUtils.copyProperties(statusType, statusTypeDTO);
            statusTypeDTOs.add(statusTypeDTO);
        }
        return statusTypeDTOs;
    }

    public List getUsersByRole(String role) {
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andRoleEqualTo(role);
        List<User> users = userMapper.selectByExample(userExample);
        List<UserDTO> collectionUserDTOs = new ArrayList();
        for (User user : users) {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(user, userDTO);
            collectionUserDTOs.add(userDTO);
        }
        return collectionUserDTOs;
    }

    @Override
    public void wasteRecordUpdate(Integer wasteRecordId, Integer wasteTypeId, BigDecimal weight, Integer collectionPointId, String collectionTime, Integer statusId, Integer collectionAccountId) {
        WasteRecord record = new WasteRecord();
        WasteRecord oldRecord = wasteRecordMapper.selectByPrimaryKey(wasteRecordId);
        BeanUtils.copyProperties(oldRecord, record);
        record.setWasteRecordId(wasteRecordId);
        record.setWasteTypeId(wasteTypeId);
        record.setWeight(weight);
        record.setCollectionPointId(collectionPointId);
        // 收集时间
        Date date = DateUtil.parse(collectionTime, "yyyy-MM-dd HH:mm:ss");
        long collectionTimeStepMillis = date.getTime();
        Integer collectionTimestamp = Math.toIntExact(collectionTimeStepMillis / 1000);
        record.setCollectionTime(collectionTimestamp);
        record.setStatus(statusId);
        record.setCollectionAccountId(collectionAccountId);

        // TODO 公共字段填充-时间
        long timeMillis = System.currentTimeMillis();
        Integer timestamp = Math.toIntExact(timeMillis / 1000);
        record.setGmtModified(timestamp);

        wasteRecordMapper.updateByPrimaryKey(record);
    }

    @Override
    public void transportRecordUpdateByWasteRecordId(Integer wasteRecordId, Integer collectionPointId, Integer disposalPointId, String transportTime, String transportVehicle, Integer transportAccountId) {
        TransportRecordExample example = new TransportRecordExample();
        example.createCriteria()
                .andWasteRecordIdEqualTo(wasteRecordId);
        List<TransportRecord> transportRecords = transportRecordMapper.selectByExample(example);
        TransportRecord oldRecord = transportRecords.get(0);

        TransportRecord record = new TransportRecord();
        BeanUtils.copyProperties(oldRecord, record);
        record.setCollectionPointId(collectionPointId);
        record.setDisposalPointId(disposalPointId);
        // 运输时间
        Date date = DateUtil.parse(transportTime, "yyyy-MM-dd HH:mm:ss");
        long transportTimeStepMillis = date.getTime();
        Integer transportTimestamp = Math.toIntExact(transportTimeStepMillis / 1000);
        record.setTransportTime(transportTimestamp);
        record.setTransportVehicle(transportVehicle);
        record.setTransportAccountId(transportAccountId);

        // TODO 公共字段填充-时间
        long timeMillis = System.currentTimeMillis();
        Integer timestamp = Math.toIntExact(timeMillis / 1000);
        record.setGmtModified(timestamp);

        transportRecordMapper.updateByPrimaryKey(record);

    }

    @Override
    public void disposalRecordUpdateByWasteRecordId(Integer wasteRecordId, Integer disposalMethodId, Integer disposalPointId, String disposalTime, Integer disposalAccountId) {
        DisposalRecord record = new DisposalRecord();
        DisposalRecord oldRecord = disposalRecordMapper.selectByPrimaryKey(wasteRecordId);
        BeanUtils.copyProperties(oldRecord, record);
        record.setDisposalPointId(disposalPointId);
        record.setDisposalMethodId(disposalMethodId);
        record.setDisposalPointId(disposalPointId);
        // 处理时间
        Date date = DateUtil.parse(disposalTime, "yyyy-MM-dd HH:mm:ss");
        long disposalTimeStepMillis = date.getTime();
        Integer disposalTimestamp = Math.toIntExact(disposalTimeStepMillis / 1000);
        record.setDisposalTime(disposalTimestamp);
        record.setDisposalAccountId(disposalAccountId);

        // TODO 公共字段填充-时间
        long timeMillis = System.currentTimeMillis();
        Integer timestamp = Math.toIntExact(timeMillis / 1000);
        record.setGmtModified(timestamp);
        disposalRecordMapper.updateByPrimaryKey(record);
    }

    @Override
    public void wasteRecordDelete(Integer wasteRecordId) {
        WasteRecord wasteRecord = wasteRecordMapper.selectByPrimaryKey(wasteRecordId);
        if (wasteRecord.getStatus() != 1) {
            throw new CustomizeException(CustomizeErrorCode.DELETE_ERROR);
        }
        wasteRecordMapper.deleteByPrimaryKey(wasteRecordId);
    }

    @Override
    public void transportRecordDeleteByWasteRecordId(Integer wasteRecordId) {
        WasteRecord wasteRecord = wasteRecordMapper.selectByPrimaryKey(wasteRecordId);
        if (wasteRecord.getStatus() == 3) {
            throw new CustomizeException(CustomizeErrorCode.DELETE_ERROR);
        }
        TransportRecordExample transportRecordExample = new TransportRecordExample();
        transportRecordExample.createCriteria()
                .andWasteRecordIdEqualTo(wasteRecordId);
        List<TransportRecord> transportRecords = transportRecordMapper.selectByExample(transportRecordExample);
        TransportRecord transportRecord = transportRecords.get(0);
        transportRecordMapper.deleteByPrimaryKey(transportRecord.getTransportId());
        wasteRecord.setStatus(1);
        wasteRecordMapper.updateByPrimaryKey(wasteRecord);

    }

    @Override
    public void disposalRecordDeleteByWasteRecordId(Integer wasteRecordId) {
        WasteRecord wasteRecord = wasteRecordMapper.selectByPrimaryKey(wasteRecordId);
        DisposalRecordExample disposalRecordExample = new DisposalRecordExample();
        disposalRecordExample.createCriteria()
                .andWasteRecordIdEqualTo(wasteRecordId);
        List<DisposalRecord> disposalRecords = disposalRecordMapper.selectByExample(disposalRecordExample);
        DisposalRecord disposalRecord = disposalRecords.get(0);
        disposalRecordMapper.deleteByPrimaryKey(disposalRecord.getDisposalId());
        wasteRecord.setStatus(2);
        wasteRecordMapper.updateByPrimaryKey(wasteRecord);
    }

    @Override
    public PaginationDTO employeeWorkPagination(Integer sEcho, Integer iDisplayStart, Integer iDisplayLength, String sSearch) {
        Long totalRecords = userMapper.countByExample(new UserExample());
        UserExample userExample = new UserExample();
        if (sSearch != null && !sSearch.trim().isEmpty()) {
            // 创建第一个条件
            UserExample.Criteria criteria1 = userExample.createCriteria();
            criteria1.andUsernameLike("%" + sSearch + "%");

            // 创建第四个条件
            UserExample.Criteria criteria2 = userExample.or();
            criteria2.andRoleLike("%" + sSearch + "%");

        }
        // 获取筛选后的记录数
        Long totalFiltered = userMapper.countByExample(userExample);

        // 计算分页的 offset
        int offset = iDisplayStart == null ? 0 : iDisplayStart;
        int size = iDisplayLength == null ? 10 : iDisplayLength;

        // 获取当前页的数据
        userExample.setOrderByClause("gmt_create desc");
        List<User> users = userMapper.selectByExampleWithRowbounds(userExample, new RowBounds(offset, size));
        List userWorkDTOs = new ArrayList();

        Integer todayStartTimestamp = TimeUtils.getTodayStartTimestamp();
        Integer monthStartTimestamp = TimeUtils.getMonthStartTimestamp();
        Integer nowTimestamp = TimeUtils.getCurrentTimestamp();

        for (User user : users) {
            UserWorkDTO userWorkDTO = new UserWorkDTO();
            BeanUtils.copyProperties(user, userWorkDTO);
            if (user.getRole().equals("收集工人")) {
                Integer countTodayData = wasteRecordExtMapper.countDataByAccountIdAndTimes(user.getAccountId(), todayStartTimestamp, nowTimestamp);
                userWorkDTO.setTodayTotal(countTodayData);

                Integer countMonthData = wasteRecordExtMapper.countDataByAccountIdAndTimes(user.getAccountId(), monthStartTimestamp, nowTimestamp);
                userWorkDTO.setMonthTotal(countMonthData);
            } else if (user.getRole().equals("司机")) {
                Integer countTodayData = transportRecordExtMapper.countDataByAccountIdAndTimes(user.getAccountId(), todayStartTimestamp, nowTimestamp);
                userWorkDTO.setTodayTotal(countTodayData);

                Integer countMonthData = transportRecordExtMapper.countDataByAccountIdAndTimes(user.getAccountId(), monthStartTimestamp, nowTimestamp);
                userWorkDTO.setMonthTotal(countMonthData);
            } else if (user.getRole().equals("处理工人")) {
                Integer countTodayData = disposalRecordExtMapper.countDataByAccountIdAndTimes(user.getAccountId(), todayStartTimestamp, nowTimestamp);
                userWorkDTO.setTodayTotal(countTodayData);

                Integer countMonthData = disposalRecordExtMapper.countDataByAccountIdAndTimes(user.getAccountId(), monthStartTimestamp, nowTimestamp);
                userWorkDTO.setMonthTotal(countMonthData);
            } else {
                // 管理员
                userWorkDTO.setTodayTotal(999);
                userWorkDTO.setMonthTotal(999);
            }
            userWorkDTOs.add(userWorkDTO);

        }
        PaginationDTO<Object> pagination = new PaginationDTO<>();
        pagination.setAaData(userWorkDTOs);
        pagination.setSEcho(sEcho); // DataTables 请求的次数
        pagination.setITotalRecords(totalRecords);
        pagination.setITotalDisplayRecords(totalFiltered);
        return pagination;
    }

    @Override
    public Integer getWorkTotalByTypeAndAccountId(String type, Integer accountId) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andAccountIdEqualTo(accountId);
        List<User> users = userMapper.selectByExample(userExample);
        User user = users.get(0);
        Integer startTimestamp = 0;
        if (type.equals("today")) {
            startTimestamp = TimeUtils.getTodayStartTimestamp();
        } else if (type.equals("month")) {
            startTimestamp = TimeUtils.getMonthStartTimestamp();
        } else if (type.equals("week")) {
            startTimestamp = TimeUtils.getWeekStartTimestamp();
        }

        Integer nowTimestamp = TimeUtils.getCurrentTimestamp();
        Integer countTodayData;


        if (user.getRole().equals("收集工人")) {
            countTodayData = wasteRecordExtMapper.countDataByAccountIdAndTimes(user.getAccountId(), startTimestamp, nowTimestamp);
        } else if (user.getRole().equals("司机")) {
            countTodayData = transportRecordExtMapper.countDataByAccountIdAndTimes(user.getAccountId(), startTimestamp, nowTimestamp);
        } else if (user.getRole().equals("处理工人")) {
            countTodayData = disposalRecordExtMapper.countDataByAccountIdAndTimes(user.getAccountId(), startTimestamp, nowTimestamp);
        } else {
            // 管理员
            countTodayData = 999;
        }
        return countTodayData;
    }

    @Override
    public List<WasteDTO> getWorkDataByTypeAndAccountId(String type, Integer accountId) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andAccountIdEqualTo(accountId);
        List<User> users = userMapper.selectByExample(userExample);
        User user = users.get(0);

        Integer startTimestamp = 0;
        if (type.equals("today")) {
            startTimestamp = TimeUtils.getTodayStartTimestamp();
        } else if (type.equals("month")) {
            startTimestamp = TimeUtils.getMonthStartTimestamp();
        } else if (type.equals("week")) {
            startTimestamp = TimeUtils.getWeekStartTimestamp();
        }
        Integer nowTimestamp = TimeUtils.getCurrentTimestamp();

        List wasteDTOs = new ArrayList();
        if (user.getRole().equals("收集工人")) {
            List<WasteRecord> wasteRecords = wasteRecordExtMapper.selectDataByAccountIdAndTimes(accountId, startTimestamp, nowTimestamp);
            for (WasteRecord wasteRecord : wasteRecords) {
                WasteDTO wasteDTO = new WasteDTO();
                BeanUtils.copyProperties(wasteRecord, wasteDTO);
                // 时间戳格式化
                Long collectionTimestamp = Long.valueOf(wasteRecord.getCollectionTime());
                wasteDTO.setCollectionTime(DateUtil.format(DateUtil.date(collectionTimestamp * 1000), "yyyy-MM-dd HH:mm:ss"));

                WasteType wasteType = wasteTypeMapper.selectByPrimaryKey(wasteRecord.getWasteTypeId());
                wasteDTO.setWasteType(wasteType.getTypeName());

                CollectionPoint collectionPoint = collectionPointMapper.selectByPrimaryKey(wasteRecord.getCollectionPointId());
                wasteDTO.setCollectionPoint(collectionPoint.getAddress());

                wasteDTOs.add(wasteDTO);
            }
        } else if (user.getRole().equals("司机")) {
            List<TransportRecord> transportRecords = transportRecordExtMapper.selectDataByAccountIdAndTimes(accountId, startTimestamp, nowTimestamp);
            for (TransportRecord transportRecord : transportRecords) {
                WasteDTO wasteDTO = new WasteDTO();
                BeanUtils.copyProperties(transportRecord, wasteDTO);

                WasteRecord wasteRecord = wasteRecordMapper.selectByPrimaryKey(wasteDTO.getWasteRecordId());
                WasteType wasteType = wasteTypeMapper.selectByPrimaryKey(wasteRecord.getWasteTypeId());
                wasteDTO.setWasteType(wasteType.getTypeName());
                CollectionPoint collectionPoint = collectionPointMapper.selectByPrimaryKey(wasteRecord.getCollectionPointId());
                wasteDTO.setCollectionPoint(collectionPoint.getAddress());
                wasteDTO.setWeight(wasteRecord.getWeight());

                Long transportTimestamp = Long.valueOf(transportRecord.getTransportTime());
                wasteDTO.setTransportTime(DateUtil.format(DateUtil.date(transportTimestamp * 1000), "yyyy-MM-dd HH:mm:ss"));

                DisposalRecordExample disposalRecordExample = new DisposalRecordExample();
                disposalRecordExample.createCriteria()
                        .andWasteRecordIdEqualTo(wasteRecord.getWasteRecordId());
                DisposalPoint disposalPoint = disposalPointMapper.selectByPrimaryKey(transportRecord.getDisposalPointId());
                wasteDTO.setDisposalPoint(disposalPoint.getAddress());


                wasteDTOs.add(wasteDTO);
            }
        } else if (user.getRole().equals("处理工人")) {
            List<DisposalRecord> disposalRecords = disposalRecordExtMapper.selectDataByAccountIdAndTimes(accountId, startTimestamp, nowTimestamp);
            for (DisposalRecord disposalRecord : disposalRecords) {
                WasteDTO wasteDTO = new WasteDTO();
                BeanUtils.copyProperties(disposalRecord, wasteDTO);

                WasteRecord wasteRecord = wasteRecordMapper.selectByPrimaryKey(wasteDTO.getWasteRecordId());
                wasteDTO.setWeight(wasteRecord.getWeight());
                WasteType wasteType = wasteTypeMapper.selectByPrimaryKey(wasteRecord.getWasteTypeId());
                wasteDTO.setWasteType(wasteType.getTypeName());

                Long disposalTimestamp = Long.valueOf(disposalRecord.getDisposalTime());
                wasteDTO.setDisposalTime(DateUtil.format(DateUtil.date(disposalTimestamp * 1000), "yyyy-MM-dd HH:mm:ss"));

                DisposalPoint disposalPoint = disposalPointMapper.selectByPrimaryKey(disposalRecord.getDisposalPointId());
                wasteDTO.setDisposalPoint(disposalPoint.getAddress());

                wasteDTOs.add(wasteDTO);
            }
        } else {
            // 管理员

        }


        return wasteDTOs;
    }

    @Override
    public Integer getWasteTotalByTime(String timeType, String dataType) {
        Integer startTimestamp = 0;
        if (timeType.equals("today")) {
            startTimestamp = TimeUtils.getTodayStartTimestamp();
        } else if (timeType.equals("month")) {
            startTimestamp = TimeUtils.getMonthStartTimestamp();
        } else if (timeType.equals("week")) {
            startTimestamp = TimeUtils.getWeekStartTimestamp();
        }
        Integer nowTimestamp = TimeUtils.getCurrentTimestamp();
        Integer result;
        if (dataType.equals("collection")) {
            result = wasteRecordExtMapper.countDataByTimes(startTimestamp, nowTimestamp);
        } else if (dataType.equals("disposal")) {
            result = disposalRecordExtMapper.countDataByTimes(startTimestamp, nowTimestamp);
        } else if (dataType.equals("transport")) {
            result = transportRecordExtMapper.countDataByTimes(startTimestamp, nowTimestamp);
        } else {
            Integer collectionCountData = wasteRecordExtMapper.countDataByTimes(startTimestamp, nowTimestamp);
            Integer disposalCountData = disposalRecordExtMapper.countDataByTimes(startTimestamp, nowTimestamp);
            Integer transportCountData = transportRecordExtMapper.countDataByTimes(startTimestamp, nowTimestamp);
            result = collectionCountData + disposalCountData + transportCountData;
        }

        return result;
    }

    @Override
    public LineChartDataDTO getWeekDataByType(String dataType) {
        List<String> categories = List.of("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun");
        Integer startTimestamp = TimeUtils.getWeekStartTimestamp();
        Integer endTimestamp;
        List<LineSeriesDTO> series = new ArrayList<>();
        List<Integer> thisWeekData = new ArrayList<>();
        List<Integer> lastWeekData = new ArrayList<>();
        // 获取当前日期
        LocalDate today = LocalDate.now();
        // 获取当前日期是星期几
        DayOfWeek dayOfWeek = today.getDayOfWeek();
        // 将 DayOfWeek 转换为索引值（星期一为 0，星期二为 1，依此类推）
        int index = dayOfWeek.getValue() - 1;

        if (dataType.equals("collection")) {
            for (int i = 0; i <= index; i++) {
                endTimestamp = startTimestamp + 86400;
                Integer countDataByTimes = wasteRecordExtMapper.countDataByTimes(startTimestamp, endTimestamp);
                thisWeekData.add(countDataByTimes);
                startTimestamp += 86400;
            }

            Integer lastWeekStartTimestamp = TimeUtils.getWeekStartTimestamp() - 604800;
            for (int i = 0; i < 7; i++) {
                endTimestamp = lastWeekStartTimestamp + 86400;
                Integer countDataByTimes = wasteRecordExtMapper.countDataByTimes(lastWeekStartTimestamp, endTimestamp);
                lastWeekData.add(countDataByTimes);
                lastWeekStartTimestamp += 86400;
            }

            // series.add(new LineSeriesDTO("本周废弃物收集", List.of(110, 14, 17, 11, 9, 8, 10)));
            series.add(new LineSeriesDTO("本周废弃物收集", thisWeekData));
            series.add(new LineSeriesDTO("上周废弃物收集", lastWeekData));
        } else if (dataType.equals("transport")) {
            for (int i = 0; i <= index; i++) {
                endTimestamp = startTimestamp + 86400;
                Integer countDataByTimes = transportRecordExtMapper.countDataByTimes(startTimestamp, endTimestamp);
                thisWeekData.add(countDataByTimes);
                startTimestamp += 86400;
            }

            Integer lastWeekStartTimestamp = TimeUtils.getWeekStartTimestamp() - 604800;
            for (int i = 0; i < 7; i++) {
                endTimestamp = lastWeekStartTimestamp + 86400;
                Integer countDataByTimes = transportRecordExtMapper.countDataByTimes(lastWeekStartTimestamp, endTimestamp);
                lastWeekData.add(countDataByTimes);
                lastWeekStartTimestamp += 86400;
            }

            // series.add(new LineSeriesDTO("本周废弃物收集", List.of(110, 14, 17, 11, 9, 8, 10)));
            series.add(new LineSeriesDTO("本周废弃物运输", thisWeekData));
            series.add(new LineSeriesDTO("上周废弃物运输", lastWeekData));
        } else {
            for (int i = 0; i <= index; i++) {
                endTimestamp = startTimestamp + 86400;
                Integer countDataByTimes = disposalRecordExtMapper.countDataByTimes(startTimestamp, endTimestamp);
                thisWeekData.add(countDataByTimes);
                startTimestamp += 86400;
            }

            Integer lastWeekStartTimestamp = TimeUtils.getWeekStartTimestamp() - 604800;
            for (int i = 0; i < 7; i++) {
                endTimestamp = lastWeekStartTimestamp + 86400;
                Integer countDataByTimes = disposalRecordExtMapper.countDataByTimes(lastWeekStartTimestamp, endTimestamp);
                lastWeekData.add(countDataByTimes);
                lastWeekStartTimestamp += 86400;
            }

            // series.add(new LineSeriesDTO("本周废弃物收集", List.of(110, 14, 17, 11, 9, 8, 10)));
            series.add(new LineSeriesDTO("本周废弃物处理", thisWeekData));
            series.add(new LineSeriesDTO("上周废弃物处理", lastWeekData));
        }

        // 封装为 ChartData 对象
        LineChartDataDTO chartData = new LineChartDataDTO(categories, series);

        return chartData;
    }

    @Override
    public List<PieChartDataDTO> getWasteTypeDistribute() {
        List<PieChartDataDTO> chartDataDTOs = new ArrayList<PieChartDataDTO>();
        List<WasteType> wasteTypes = wasteTypeMapper.selectByExample(new WasteTypeExample());
        for (WasteType wasteType : wasteTypes) {
            WasteRecordExample example = new WasteRecordExample();
            example.createCriteria()
                    .andWasteTypeIdEqualTo(wasteType.getWasteTypeId());
            List<WasteRecord> wasteRecords = wasteRecordMapper.selectByExample(example);
            Integer size = wasteRecords.size();
            PieChartDataDTO chartDataDTO = new PieChartDataDTO();
            chartDataDTO.setName(wasteType.getTypeName());
            chartDataDTO.setValue(size);
            chartDataDTOs.add(chartDataDTO);
        }
        return chartDataDTOs;
    }

    @Override
    public String getWOWdataByType(String type) {
        Integer startTimestamp = TimeUtils.getWeekStartTimestamp();
        Integer lastWeekStartTimestamp = TimeUtils.getWeekStartTimestamp() - 604800;
        Integer endTimestamp = TimeUtils.getCurrentTimestamp();
        if (type.equals("collection")) {
            Integer thisWeekData = wasteRecordExtMapper.countDataByTimes(startTimestamp, endTimestamp);
            Integer lastWeekData = wasteRecordExtMapper.countDataByTimes(lastWeekStartTimestamp, endTimestamp);
            double WOW = ((thisWeekData - lastWeekData) / (double) lastWeekData) * 100;
            return String.format("%.2f%%", WOW); // 保留两位小数并添加百分号
        } else if (type.equals("disposal")) {
            Integer thisWeekData = transportRecordExtMapper.countDataByTimes(startTimestamp, endTimestamp);
            Integer lastWeekData = transportRecordExtMapper.countDataByTimes(lastWeekStartTimestamp, endTimestamp);
            double WOW = ((thisWeekData - lastWeekData) / (double) lastWeekData) * 100;
            return String.format("%.2f%%", WOW); // 保留两位小数并添加百分号
        } else if (type.equals("transport")) {
            Integer thisWeekData = disposalRecordExtMapper.countDataByTimes(startTimestamp, endTimestamp);
            Integer lastWeekData = disposalRecordExtMapper.countDataByTimes(lastWeekStartTimestamp, endTimestamp);
            double WOW = ((thisWeekData - lastWeekData) / (double) lastWeekData) * 100;
            return String.format("%.2f%%", WOW); // 保留两位小数并添加百分号
        } else {
            Integer thisWeekData = wasteRecordExtMapper.countDataByTimes(startTimestamp, endTimestamp)
                    + transportRecordExtMapper.countDataByTimes(lastWeekStartTimestamp, endTimestamp)
                    + disposalRecordExtMapper.countDataByTimes(lastWeekStartTimestamp, endTimestamp);
            Integer lastWeekData = wasteRecordExtMapper.countDataByTimes(lastWeekStartTimestamp, endTimestamp)
                    + transportRecordExtMapper.countDataByTimes(lastWeekStartTimestamp, endTimestamp)
                    + disposalRecordExtMapper.countDataByTimes(lastWeekStartTimestamp, endTimestamp);
            double WOW = ((thisWeekData - lastWeekData) / (double) lastWeekData) * 100;
            return String.format("%.2f%%", WOW); // 保留两位小数并添加百分号
        }
    }

    @Override
    public LineChartDataDTO getWasteDataByMonth(Integer year, Integer month) {
        List<String> daysInMonth = TimeUtils.getDaysInMonth(year, month);

        List<LineSeriesDTO> series = new ArrayList<>();
        List<Integer> collectionData = new ArrayList<>();
        List<Integer> transportData = new ArrayList<>();
        List<Integer> disposalData = new ArrayList<>();

        Integer startOfMonthTimestamp = TimeUtils.getStartOfMonthTimestamp(year, month);
        Integer startTimestamp = startOfMonthTimestamp;
        Integer endTimestamp;
        for (int i = 0; i < daysInMonth.size(); i++) {
            endTimestamp = startTimestamp + 86400;
            Integer collectionDataDaily = wasteRecordExtMapper.countDataByTimes(startTimestamp, endTimestamp);
            collectionData.add(collectionDataDaily);
            Integer transportDataDaily = transportRecordExtMapper.countDataByTimes(startTimestamp, endTimestamp);
            transportData.add(transportDataDaily);
            Integer disposalDataDaily = disposalRecordExtMapper.countDataByTimes(startTimestamp, endTimestamp);
            disposalData.add(disposalDataDaily);
            startTimestamp += 86400;
        }
        series.add(new LineSeriesDTO(year + "年" + month +"月-废弃物收集信息", collectionData));
        series.add(new LineSeriesDTO(year + "年" + month +"月-废弃物运输信息", transportData));
        series.add(new LineSeriesDTO(year + "年" + month +"月-废弃物处理信息", disposalData));



        // 封装为 ChartData 对象
        LineChartDataDTO chartData = new LineChartDataDTO(daysInMonth, series);

        return chartData;
    }

    @Override
    public List getMainWasteCollectionPoints() {

        HashMap<String, Integer> sourceWasteMap = new HashMap<>();

        List<CollectionPoint> collectionPoints = collectionPointMapper.selectByExample(new CollectionPointExample());
        for (CollectionPoint collectionPoint : collectionPoints) {
            WasteRecordExample example = new WasteRecordExample();
            example.createCriteria()
                            .andCollectionPointIdEqualTo(collectionPoint.getCollectionPointId());
            List<WasteRecord> collectionPointRecords = wasteRecordMapper.selectByExample(example);
            Integer collectionPointSize = collectionPointRecords.size();
            sourceWasteMap.put(collectionPoint.getAddress(), collectionPointSize);
        }

        // 将Map.Entry转换为列表，并按废弃物量降序排序
        List<Map.Entry<String, Integer>> sortedSources = new ArrayList<>(sourceWasteMap.entrySet());
        sortedSources.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        // 提取废弃物量最多的两个来源地
        List<String> mainSourcesCollectionPoint = new ArrayList<>();
        for (int i = 0; i < Math.min(2, sortedSources.size()); i++) {
            mainSourcesCollectionPoint.add(sortedSources.get(i).getKey());
        }

        return mainSourcesCollectionPoint;
    }

    @Override
    public List getDisposalMethods() {
        List<DisposalMethodDTO> disposalMethodDTOs = new ArrayList<>();
        List<DisposalMethod> disposalMethods = disposalMethodMapper.selectByExample(new DisposalMethodExample());
        for (DisposalMethod disposalMethod : disposalMethods) {
            DisposalMethodDTO disposalMethodDTO = new DisposalMethodDTO();
            disposalMethodDTO.setDisposalMethodId(disposalMethod.getDisposalMethodId());
            disposalMethodDTO.setDisposalMethod(disposalMethod.getDisposalMethodName());
            disposalMethodDTOs.add(disposalMethodDTO);
        }
        return disposalMethodDTOs;
    }

    @Override
    public List getMainDisposalMethods() {

        HashMap<String, Integer> disposalMethodsMap = new HashMap<>();

        List<DisposalMethod> disposalMethods = disposalMethodMapper.selectByExample(new DisposalMethodExample());
        for (DisposalMethod disposalMethod : disposalMethods) {
            DisposalRecordExample disposalRecordExample = new DisposalRecordExample();
            disposalRecordExample.createCriteria()
                            .andDisposalMethodIdEqualTo(disposalMethod.getDisposalMethodId());
            List<DisposalRecord> disposalRecords = disposalRecordMapper.selectByExample(disposalRecordExample);
            Integer disposalRecordSize = disposalRecords.size();
            disposalMethodsMap.put(disposalMethod.getDisposalMethodName(), disposalRecordSize);
        }
        // 将Map.Entry转换为列表，并按处理记录数量降序排序
        List<Map.Entry<String, Integer>> sortedDisposalMethods = new ArrayList<>(disposalMethodsMap.entrySet());
        sortedDisposalMethods.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        // 提取使用最多的两种处理方式
        List<String> mainDisposalMethods = new ArrayList<>();
        for (int i = 0; i < Math.min(2, sortedDisposalMethods.size()); i++) {
            mainDisposalMethods.add(sortedDisposalMethods.get(i).getKey());
        }

        return mainDisposalMethods;
    }

    @Override
    public List<PieChartDataDTO> getCollectionPointsDataByMonth(Integer year, Integer month) {
        List<PieChartDataDTO> pieChartDataDTOs = new ArrayList<>();
        List<CollectionPoint> collectionPoints = collectionPointMapper.selectByExample(new CollectionPointExample());
        for (CollectionPoint collectionPoint : collectionPoints) {
            Integer startOfMonthTimestamp = TimeUtils.getStartOfMonthTimestamp(year, month);
            Integer endTimestamp = TimeUtils.getTimestampForMonth(year, month);
            Integer countDataByTimes = wasteRecordExtMapper.countDataByPointIdAndTimes(collectionPoint.getCollectionPointId(), startOfMonthTimestamp, endTimestamp);
            PieChartDataDTO pieChartDataDTO = new PieChartDataDTO();
            pieChartDataDTO.setName(collectionPoint.getAddress());
            pieChartDataDTO.setValue(countDataByTimes);
            pieChartDataDTOs.add(pieChartDataDTO);
        }
        return pieChartDataDTOs;
    }

    @Override
    public List<PieChartDataDTO> getDisposalMethodsDataByMonth(Integer year, Integer month) {
        List<PieChartDataDTO> pieChartDataDTOs = new ArrayList<>();
        List<DisposalMethod> disposalMethods = disposalMethodMapper.selectByExample(new DisposalMethodExample());
        for (DisposalMethod disposalMethod : disposalMethods) {
            Integer startOfMonthTimestamp = TimeUtils.getStartOfMonthTimestamp(year, month);
            Integer endTimestamp = TimeUtils.getTimestampForMonth(year, month);
            Integer countDataByTimes = disposalRecordExtMapper.countDataByDisposalMethodIdAndTimes(disposalMethod.getDisposalMethodId(), startOfMonthTimestamp, endTimestamp);
            PieChartDataDTO pieChartDataDTO = new PieChartDataDTO();
            pieChartDataDTO.setName(disposalMethod.getDisposalMethodName());
            pieChartDataDTO.setValue(countDataByTimes);
            pieChartDataDTOs.add(pieChartDataDTO);
        }
        return pieChartDataDTOs;
    }

    @Override
    public DrilldownBarChartDTO getInitialQuarterData() {
        DrilldownBarChartDTO drilldownBarChartDTO = new DrilldownBarChartDTO();
        List<String> initialQuarterCategories = new ArrayList<>();
        initialQuarterCategories.add("第一季度");
        initialQuarterCategories.add("第二季度");
        initialQuarterCategories.add("第三季度");
        initialQuarterCategories.add("第四季度");
        drilldownBarChartDTO.setCategories(initialQuarterCategories);

        Integer firstQuarterTimestamp = TimeUtils.getStartOfMonthTimestamp(Year.now().getValue(), 1);
        Integer firstQuarterEndTimestamp = TimeUtils.getTimestampForMonth(Year.now().getValue(), 4) - 1;
        Integer firstQuarterData = wasteRecordExtMapper.countDataByTimes(firstQuarterTimestamp, firstQuarterEndTimestamp);

        Integer secondQuarterTimestamp = TimeUtils.getStartOfMonthTimestamp(Year.now().getValue(), 4);
        Integer secondQuarterEndTimestamp = TimeUtils.getTimestampForMonth(Year.now().getValue(), 7) - 1;
        Integer secondQuarterData = wasteRecordExtMapper.countDataByTimes(secondQuarterTimestamp, secondQuarterEndTimestamp);

        Integer thirdQuarterTimestamp = TimeUtils.getStartOfMonthTimestamp(Year.now().getValue(), 7);
        Integer thirdQuarterEndTimestamp = TimeUtils.getTimestampForMonth(Year.now().getValue(), 10) - 1;
        Integer thirdQuarterData = wasteRecordExtMapper.countDataByTimes(thirdQuarterTimestamp, thirdQuarterEndTimestamp);

        Integer fourthQuarterTimestamp = TimeUtils.getStartOfMonthTimestamp(Year.now().getValue(), 10);
        Integer fourthQuarterEndTimestamp = TimeUtils.getTimestampForMonth(Year.now().getValue() + 1, 1) - 1;
        Integer fourthQuarterData = wasteRecordExtMapper.countDataByTimes(fourthQuarterTimestamp, fourthQuarterEndTimestamp);

        List<Integer> initialQuarterData = new ArrayList<>();
        initialQuarterData.add(firstQuarterData);
        initialQuarterData.add(secondQuarterData);
        initialQuarterData.add(thirdQuarterData);
        initialQuarterData.add(fourthQuarterData);
        drilldownBarChartDTO.setSeriesData(initialQuarterData);

        return drilldownBarChartDTO;
    }

    @Override
    public DrilldownBarChartDTO getDrilldownInitialQuarterData(String groupId) {
        Integer month1;
        Integer month2;
        Integer month3;
        if (groupId.equals("第一季度")){
            month1 = 1;
            month2 = 2;
            month3 = 3;
        }else if (groupId.equals("第二季度")){
            month1 = 4;
            month2 = 5;
            month3 = 6;
        }else if (groupId.equals("第三季度")){
            month1 = 7;
            month2 = 8;
            month3 = 9;
        }else {
            month1 = 10;
            month2 = 11;
            month3 = 12;
        }
        DrilldownBarChartDTO drilldownBarChartDTO = new DrilldownBarChartDTO();
        List<String> initialQuarterCategories = new ArrayList<>();
        initialQuarterCategories.add(month1 + "月");
        initialQuarterCategories.add(month2 + "月");
        initialQuarterCategories.add(month3 + "月");
        drilldownBarChartDTO.setCategories(initialQuarterCategories);

        Integer firstMonthTimestamp = TimeUtils.getStartOfMonthTimestamp(Year.now().getValue(), month1);
        Integer firstMonthEndTimestamp = TimeUtils.getTimestampForMonth(Year.now().getValue(), month1);
        Integer firstMonthData = wasteRecordExtMapper.countDataByTimes(firstMonthTimestamp, firstMonthEndTimestamp);

        Integer secondMonthTimestamp = TimeUtils.getStartOfMonthTimestamp(Year.now().getValue(), month2);
        Integer secondMonthEndTimestamp = TimeUtils.getTimestampForMonth(Year.now().getValue(), month2);
        Integer secondMonthData = wasteRecordExtMapper.countDataByTimes(secondMonthTimestamp, secondMonthEndTimestamp);

        Integer thirdMonthTimestamp = TimeUtils.getStartOfMonthTimestamp(Year.now().getValue(), month3);
        Integer thirdMonthEndTimestamp = TimeUtils.getTimestampForMonth(Year.now().getValue(), month3);
        Integer thirdMonthData = wasteRecordExtMapper.countDataByTimes(thirdMonthTimestamp, thirdMonthEndTimestamp);

        List<Integer> initialQuarterData = new ArrayList<>();
        initialQuarterData.add(firstMonthData);
        initialQuarterData.add(secondMonthData);
        initialQuarterData.add(thirdMonthData);
        drilldownBarChartDTO.setSeriesData(initialQuarterData);

        return drilldownBarChartDTO;
    }

    @Override
    public String getmainQuarter() {
        Integer firstQuarterTimestamp = TimeUtils.getStartOfMonthTimestamp(Year.now().getValue(), 1);
        Integer firstQuarterEndTimestamp = TimeUtils.getTimestampForMonth(Year.now().getValue(), 4) - 1;
        Integer firstQuarterData = wasteRecordExtMapper.countDataByTimes(firstQuarterTimestamp, firstQuarterEndTimestamp);

        Integer secondQuarterTimestamp = TimeUtils.getStartOfMonthTimestamp(Year.now().getValue(), 4);
        Integer secondQuarterEndTimestamp = TimeUtils.getTimestampForMonth(Year.now().getValue(), 7) - 1;
        Integer secondQuarterData = wasteRecordExtMapper.countDataByTimes(secondQuarterTimestamp, secondQuarterEndTimestamp);

        Integer thirdQuarterTimestamp = TimeUtils.getStartOfMonthTimestamp(Year.now().getValue(), 7);
        Integer thirdQuarterEndTimestamp = TimeUtils.getTimestampForMonth(Year.now().getValue(), 10) - 1;
        Integer thirdQuarterData = wasteRecordExtMapper.countDataByTimes(thirdQuarterTimestamp, thirdQuarterEndTimestamp);

        Integer fourthQuarterTimestamp = TimeUtils.getStartOfMonthTimestamp(Year.now().getValue(), 10);
        Integer fourthQuarterEndTimestamp = TimeUtils.getTimestampForMonth(Year.now().getValue() + 1, 1) - 1;
        Integer fourthQuarterData = wasteRecordExtMapper.countDataByTimes(fourthQuarterTimestamp, fourthQuarterEndTimestamp);

        // 初始化最大值为第一个变量
        Integer max = firstQuarterData;
        String result = "第一季度";

        // 比较四个变量，找出最大值
        if (secondQuarterData > max) {
            max = secondQuarterData;
            result = "第二季度";
        }
        if (thirdQuarterData > max) {
            max = thirdQuarterData;
            result = "第三季度";
        }
        if (fourthQuarterData > max) {
            max = fourthQuarterData;
            result = "第四季度";
        }


        return result;
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
