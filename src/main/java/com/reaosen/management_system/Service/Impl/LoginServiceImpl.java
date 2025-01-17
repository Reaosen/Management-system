package com.reaosen.management_system.Service.Impl;

import cn.hutool.core.lang.UUID;
import com.reaosen.management_system.DTO.UserDTO;
import com.reaosen.management_system.Mapper.UserMapper;
import com.reaosen.management_system.Model.User;
import com.reaosen.management_system.Model.UserExample;
import com.reaosen.management_system.Service.LoginService;
import cn.hutool.core.util.StrUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import com.reaosen.management_system.Exception.CustomizeException;
import com.reaosen.management_system.Exception.CustomizeErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

    public void login(UserDTO userDTO, HttpServletResponse response) {
        if (StrUtil.isBlank(userDTO.getEmail()) || StrUtil.isBlank(userDTO.getPassword())) {
            throw new CustomizeException(CustomizeErrorCode.IS_EMPTY);
        }
        UserExample example = new UserExample();
        example.createCriteria()
                .andEmailEqualTo(userDTO.getEmail())
                .andPasswordEqualTo(userDTO.getPassword());
        List<User> users = userMapper.selectByExample(example);
        if (users.size() == 0) {
            throw new CustomizeException(CustomizeErrorCode.PASSWORD_OR_EMAIL_WRONG);
        }

        // 登录成功 写cookie和session
        User user = users.get(0);
        user.setToken(UUID.randomUUID().toString());
        userMapper.updateByPrimaryKey(user);
        response.addCookie(new Cookie("token", user.getToken()));
    }
}
