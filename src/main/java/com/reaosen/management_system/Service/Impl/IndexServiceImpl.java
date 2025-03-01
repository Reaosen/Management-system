package com.reaosen.management_system.Service.Impl;

import com.reaosen.management_system.DTO.PieChartDataDTO;
import com.reaosen.management_system.Mapper.UserMapper;
import com.reaosen.management_system.Mapper.WasteRecordMapper;
import com.reaosen.management_system.Mapper.WasteTypeMapper;
import com.reaosen.management_system.Model.*;
import com.reaosen.management_system.Service.IndexService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private WasteTypeMapper wasteTypeMapper;

    @Autowired
    private WasteRecordMapper wasteRecordMapper;

    @Override
    public String index(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if ((cookies != null && cookies.length != 0)) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    UserExample userExample = new UserExample();
                    userExample.createCriteria()
                            .andTokenEqualTo(token);
                    List<User> users = userMapper.selectByExample(userExample);
                    if (!users.isEmpty()) {
                        return "index";
                    }

                }
            }
        }
        return "login";
    }


}
