package com.reaosen.management_system.Service.Impl;

import com.reaosen.management_system.DTO.PaginationDTO;
import com.reaosen.management_system.DTO.UserDTO;
import com.reaosen.management_system.Mapper.UserMapper;
import com.reaosen.management_system.Model.User;
import com.reaosen.management_system.Model.UserExample;
import com.reaosen.management_system.Service.UserService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PaginationDTO<UserDTO> pagination(Integer sEcho,
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
}
