package com.reaosen.management_system.Service.Impl;

import cn.hutool.core.lang.UUID;
import com.reaosen.management_system.DTO.TempUserDTO;
import com.reaosen.management_system.Mapper.UserMapper;
import com.reaosen.management_system.Model.User;
import com.reaosen.management_system.Model.UserExample;
import com.reaosen.management_system.Service.LoginService;
import cn.hutool.core.util.StrUtil;
import com.reaosen.management_system.Utils.JwtUtils;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import com.reaosen.management_system.Exception.CustomizeException;
import com.reaosen.management_system.Exception.CustomizeErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

    public void login(TempUserDTO userDTO, HttpServletResponse response) {
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
        //TODO JWT token 更新
        Integer accountId = user.getAccountId();
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("username", user.getName());
        claims.put("tel", user.getTel());
        String token = JwtUtils.createToken(String.valueOf(accountId), claims, 86400);
        user.setToken(token);
        userMapper.updateByPrimaryKey(user);
        response.addCookie(new Cookie("token", user.getToken()));

//        user.setToken(UUID.randomUUID().toString());
//        userMapper.updateByPrimaryKey(user);
//        response.addCookie(new Cookie("token", user.getToken()));
    }
}
