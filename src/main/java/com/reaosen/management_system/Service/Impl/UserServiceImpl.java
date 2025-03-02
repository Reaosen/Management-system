package com.reaosen.management_system.Service.Impl;

import com.reaosen.management_system.DTO.PaginationDTO;
import com.reaosen.management_system.DTO.UserContributionDTO;
import com.reaosen.management_system.DTO.UserDTO;
import com.reaosen.management_system.Mapper.*;
import com.reaosen.management_system.Model.User;
import com.reaosen.management_system.Model.UserExample;
import com.reaosen.management_system.Service.UserService;
import com.reaosen.management_system.Utils.TimeUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TransportRecordExtMapper transportRecordExtMapper;

    @Autowired
    private WasteRecordExtMapper wasteRecordExtMapper;

    @Autowired
    private DisposalRecordExtMapper disposalRecordExtMapper;

    @Override
    public PaginationDTO<UserDTO> employeePagination(Integer sEcho,
                                                     Integer iDisplayStart,
                                                     Integer iDisplayLength,
                                                     String sSearch) {
        // 获取总记录数（不考虑搜索条件）
        Long totalRecords = userMapper.countByExample(new UserExample());

        // 根据搜索条件构建 UserExample
        UserExample userExample = new UserExample();
        if (sSearch != null && !sSearch.trim().isEmpty()) {
            // 创建第一个条件
            UserExample.Criteria criteria1 = userExample.createCriteria();
            criteria1.andUsernameLike("%" + sSearch + "%");

            // 创建第二个条件
            UserExample.Criteria criteria2 = userExample.or();
            criteria2.andEmailLike("%" + sSearch + "%");

            // 创建第三个条件
            UserExample.Criteria criteria3 = userExample.or();
            criteria3.andPhoneLike("%" + sSearch + "%");

            // 创建第四个条件
            UserExample.Criteria criteria4 = userExample.or();
            criteria4.andRoleLike("%" + sSearch + "%");

        }

        // 获取筛选后的记录数
        Long totalFiltered = userMapper.countByExample(userExample);

        // 计算分页的 offset
        int offset = iDisplayStart == null ? 0 : iDisplayStart;
        int size = iDisplayLength == null ? 10 : iDisplayLength;

        // 获取当前页的数据
        userExample.setOrderByClause("gmt_create desc");
        List<User> users = userMapper.selectByExampleWithRowbounds(userExample, new RowBounds(offset, size));
        List<UserDTO> userDTOs = new ArrayList<>();
        for (User user : users) {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(user, userDTO);
            userDTOs.add(userDTO);
        }
        // 构造返回的 DTO
        PaginationDTO<UserDTO> Pagination = new PaginationDTO<>();
        Pagination.setSEcho(sEcho); // DataTables 请求的次数
        Pagination.setITotalRecords(totalRecords);
        Pagination.setITotalDisplayRecords(totalFiltered);
        Pagination.setAaData(userDTOs);

        return Pagination;
    }

    @Override
    public void updateStatusByAccountId(UserDTO userDTO) {
        Integer accountId = userDTO.getAccountId();
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andAccountIdEqualTo(accountId);
        List<User> users = userMapper.selectByExample(userExample);
        User user = users.get(0);
        user.setStatus(userDTO.getStatus());
        userMapper.updateByExample(user, userExample);
    }

    @Override
    public UserDTO getUserByAccountId(Integer accountId) {
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andAccountIdEqualTo(accountId);
        List<User> users = userMapper.selectByExample(userExample);
        User user = users.get(0);
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);

        return userDTO;
    }

    @Override
    public Integer getWorkUsersCountByTime(String timeType) {
        Integer startTimestamp = 0;
        if (timeType.equals("today")) {
            startTimestamp = TimeUtils.getTodayStartTimestamp();
        } else if (timeType.equals("month")) {
            startTimestamp = TimeUtils.getMonthStartTimestamp();
        } else if (timeType.equals("week")) {
            startTimestamp = TimeUtils.getWeekStartTimestamp();
        }
        Integer nowTimestamp = TimeUtils.getCurrentTimestamp();
        List<User> users = userMapper.selectByExample(new UserExample());
        Integer result = 0;
        for (User user : users) {
            if (user.getRole().equals("收集工人")) {
                Integer countDataByTimes = wasteRecordExtMapper.countDataByAccountIdAndTimes(user.getAccountId(), startTimestamp, nowTimestamp);
                if (countDataByTimes > 0) {
                    result++;
                }
            }else if (user.getRole().equals("司机")){
                Integer countDataByTimes = transportRecordExtMapper.countDataByAccountIdAndTimes(user.getAccountId(), startTimestamp, nowTimestamp);
                if (countDataByTimes > 0) {
                    result++;
                }
            }else{
                Integer countDataByTimes = disposalRecordExtMapper.countDataByAccountIdAndTimes(user.getAccountId(), startTimestamp, nowTimestamp);
                if (countDataByTimes > 0) {
                    result++;
                }
            }
        }
        return result;
    }

    @Override
    public List<UserContributionDTO> getUsersWeeklyContribution() {
        Integer startTimestamp = TimeUtils.getWeekStartTimestamp();
        Integer endTimestamp = TimeUtils.getCurrentTimestamp();
        List<User> users = userMapper.selectByExample(new UserExample());

        Integer thisWeekCollectionCount = wasteRecordExtMapper.countDataByTimes(startTimestamp, endTimestamp);
        Integer thisWeekTransportCount = transportRecordExtMapper.countDataByTimes(startTimestamp, endTimestamp);
        Integer thisWeekDisposalCount = disposalRecordExtMapper.countDataByTimes(startTimestamp, endTimestamp);

        List<UserContributionDTO> userContributionDTOs = new ArrayList<>();
        for (User user : users) {
            if (user.getRole().equals("收集工人")){
                Integer countDataByTimes = wasteRecordExtMapper.countDataByAccountIdAndTimes(user.getAccountId(), startTimestamp, endTimestamp);
                double result = (double) countDataByTimes / thisWeekCollectionCount * 100;
                int finalResult = (int) Math.round(result);
                UserContributionDTO userContributionDTO = new UserContributionDTO();
                BeanUtils.copyProperties(user, userContributionDTO);
                userContributionDTO.setContribution(finalResult);
                userContributionDTOs.add(userContributionDTO);
            }else if (user.getRole().equals("司机")){
                Integer countDataByTimes = transportRecordExtMapper.countDataByAccountIdAndTimes(user.getAccountId(), startTimestamp, endTimestamp);
                double result = (double) countDataByTimes / thisWeekTransportCount * 100;
                int finalResult = (int) Math.round(result);
                UserContributionDTO userContributionDTO = new UserContributionDTO();
                BeanUtils.copyProperties(user, userContributionDTO);
                userContributionDTO.setContribution(finalResult);
                userContributionDTOs.add(userContributionDTO);
            }else if (user.getRole().equals("处理工人")){
                Integer countDataByTimes = disposalRecordExtMapper.countDataByAccountIdAndTimes(user.getAccountId(), startTimestamp, endTimestamp);
                double result = (double) countDataByTimes / thisWeekDisposalCount * 100;
                int finalResult = (int) Math.round(result);
                UserContributionDTO userContributionDTO = new UserContributionDTO();
                BeanUtils.copyProperties(user, userContributionDTO);
                userContributionDTO.setContribution(finalResult);
                userContributionDTOs.add(userContributionDTO);
            }
        }

        // 按 contribution 属性降序排序
        // 按 contribution 属性降序排序
        Collections.sort(userContributionDTOs, new Comparator<UserContributionDTO>() {
            @Override
            public int compare(UserContributionDTO o1, UserContributionDTO o2) {
                // 注意：这里需要处理 contribution 为 null 的情况
                if (o1.getContribution() == null) return (o2.getContribution() == null) ? 0 : 1;
                if (o2.getContribution() == null) return -1;
                return o2.getContribution().compareTo(o1.getContribution());
            }
        });

        // 提取前五条数据
        List<UserContributionDTO> topFive = new ArrayList<>();
        int size = Math.min(users.size(), 5); // 防止不足五条时报错
        for (int i = 0; i < size; i++) {
            topFive.add(userContributionDTOs.get(i));
        }


        return topFive;
    }
}
