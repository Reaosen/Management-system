package com.reaosen.management_system.Service.Impl;

import cn.hutool.core.date.DateUtil;
import com.reaosen.management_system.DTO.*;
import com.reaosen.management_system.Exception.CustomizeErrorCode;
import com.reaosen.management_system.Exception.CustomizeException;
import com.reaosen.management_system.Mapper.*;
import com.reaosen.management_system.Model.*;
import com.reaosen.management_system.Service.WasteService;
import com.reaosen.management_system.Utils.TimestampUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        //收集时间
        record.setCollectionTime(timestamp);
        //TODO 公共字段填充-时间
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
    public void wasteDisposalInsert(Integer disposalPointId, Integer wasteRecordId, String disposalMethod, Integer collectionAccountId) {
        DisposalRecord record = new DisposalRecord();
        record.setWasteRecordId(wasteRecordId);
        record.setDisposalAccountId(collectionAccountId);
        record.setDisposalPointId(disposalPointId);
        record.setDisposalMethod(disposalMethod);
        long timeMillis = System.currentTimeMillis();
        Integer timestamp = Math.toIntExact(timeMillis / 1000);
        //处理时间
        record.setDisposalTime(timestamp);

        WasteRecord wasteRecord = wasteRecordMapper.selectByPrimaryKey(wasteRecordId);
        wasteRecord.setStatus(3);
        //TODO 公共字段填充-时间
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


        long timeMillis = System.currentTimeMillis();
        Integer timeStamp = Math.toIntExact(timeMillis / 1000);
        //运输时间
        record.setTransportTime(timeStamp);

        WasteRecord wasteRecord = wasteRecordMapper.selectByPrimaryKey(wasteRecordId);
        wasteRecord.setStatus(2);

        //TODO 公共字段填充-时间

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
                wasteDTO.setDisposalMethod(disposalRecord.getDisposalMethod());
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
        //收集时间
        Date date = DateUtil.parse(collectionTime, "yyyy-MM-dd HH:mm:ss");
        long collectionTimeStepMillis = date.getTime();
        Integer collectionTimestamp = Math.toIntExact(collectionTimeStepMillis / 1000);
        record.setCollectionTime(collectionTimestamp);
        record.setStatus(statusId);
        record.setCollectionAccountId(collectionAccountId);

        //TODO 公共字段填充-时间
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
        //运输时间
        Date date = DateUtil.parse(transportTime, "yyyy-MM-dd HH:mm:ss");
        long transportTimeStepMillis = date.getTime();
        Integer transportTimestamp = Math.toIntExact(transportTimeStepMillis / 1000);
        record.setTransportTime(transportTimestamp);
        record.setTransportVehicle(transportVehicle);
        record.setTransportAccountId(transportAccountId);

        //TODO 公共字段填充-时间
        long timeMillis = System.currentTimeMillis();
        Integer timestamp = Math.toIntExact(timeMillis / 1000);
        record.setGmtModified(timestamp);

        transportRecordMapper.updateByPrimaryKey(record);

    }

    @Override
    public void disposalRecordUpdateByWasteRecordId(Integer wasteRecordId, String disposalMethod, Integer disposalPointId, String disposalTime, Integer disposalAccountId) {
        DisposalRecord record = new DisposalRecord();
        DisposalRecord oldRecord = disposalRecordMapper.selectByPrimaryKey(wasteRecordId);
        BeanUtils.copyProperties(oldRecord, record);
        record.setDisposalPointId(disposalPointId);
        record.setDisposalMethod(disposalMethod);
        record.setDisposalPointId(disposalPointId);
        //处理时间
        Date date = DateUtil.parse(disposalTime, "yyyy-MM-dd HH:mm:ss");
        long disposalTimeStepMillis = date.getTime();
        Integer disposalTimestamp = Math.toIntExact(disposalTimeStepMillis / 1000);
        record.setDisposalTime(disposalTimestamp);
        record.setDisposalAccountId(disposalAccountId);

        //TODO 公共字段填充-时间
        long timeMillis = System.currentTimeMillis();
        Integer timestamp = Math.toIntExact(timeMillis / 1000);
        record.setGmtModified(timestamp);
        disposalRecordMapper.updateByPrimaryKey(record);
    }

    @Override
    public void wasteRecordDelete(Integer wasteRecordId) {
        WasteRecord wasteRecord = wasteRecordMapper.selectByPrimaryKey(wasteRecordId);
        if (wasteRecord.getStatus() != 1){
            throw new CustomizeException(CustomizeErrorCode.DELETE_ERROR);
        }
        wasteRecordMapper.deleteByPrimaryKey(wasteRecordId);
    }

    @Override
    public void transportRecordDeleteByWasteRecordId(Integer wasteRecordId) {
        WasteRecord wasteRecord = wasteRecordMapper.selectByPrimaryKey(wasteRecordId);
        if (wasteRecord.getStatus() == 3){
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
        //TODO 未完成的员工工作分页查询
        // 获取总记录数（不考虑搜索条件）
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

        Integer todayStartTimestamp = TimestampUtils.getTodayStartTimestamp();
        Integer monthStartTimestamp = TimestampUtils.getMonthStartTimestamp();
        Integer nowTimestamp = TimestampUtils.getCurrentTimestamp();

        for (User user : users) {
            UserWorkDTO userWorkDTO = new UserWorkDTO();
            BeanUtils.copyProperties(user, userWorkDTO);
            if(user.getRole().equals("收集工人")){
                Integer countTodayData = wasteRecordExtMapper.countDataByTimes(user.getAccountId(), todayStartTimestamp, nowTimestamp);
                userWorkDTO.setTodayTotal(countTodayData);

                Integer countMonthData = wasteRecordExtMapper.countDataByTimes(user.getAccountId(), monthStartTimestamp, nowTimestamp);
                userWorkDTO.setMonthTotal(countMonthData);
            }else if (user.getRole().equals("司机")){
                Integer countTodayData = transportRecordExtMapper.countDataByTimes(user.getAccountId(), todayStartTimestamp, nowTimestamp);
                userWorkDTO.setTodayTotal(countTodayData);

                Integer countMonthData = transportRecordExtMapper.countDataByTimes(user.getAccountId(), monthStartTimestamp, nowTimestamp);
                userWorkDTO.setMonthTotal(countMonthData);
            }else if (user.getRole().equals("处理工人")){
                Integer countTodayData = disposalRecordExtMapper.countDataByTimes(user.getAccountId(), todayStartTimestamp, nowTimestamp);
                userWorkDTO.setTodayTotal(countTodayData);

                Integer countMonthData = disposalRecordExtMapper.countDataByTimes(user.getAccountId(), monthStartTimestamp, nowTimestamp);
                userWorkDTO.setMonthTotal(countMonthData);
            }else {
                //管理员
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
