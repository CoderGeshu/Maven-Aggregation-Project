package com.eric.service.impl;

import com.eric.mapper.UserMapper;
import com.eric.pojo.User;
import com.eric.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Date: 2020/12/22 10:54
 * @author: Eric
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    public void addUser(User user) {
        this.userMapper.insertUser(user);
    }
}
