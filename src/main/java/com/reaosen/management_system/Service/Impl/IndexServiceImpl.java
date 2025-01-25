package com.reaosen.management_system.Service.Impl;

import com.reaosen.management_system.DTO.UserDTO;
import com.reaosen.management_system.Mapper.UserMapper;
import com.reaosen.management_system.Model.User;
import com.reaosen.management_system.Model.UserExample;
import com.reaosen.management_system.Service.IndexService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Object index(UserDTO userDTO) {
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andTokenEqualTo(userDTO.getToken());
        List<User> users = userMapper.selectByExample(userExample);
        UserDTO user = new UserDTO();
        BeanUtils.copyProperties(users.get(0), user);

        return user;
    }
}
