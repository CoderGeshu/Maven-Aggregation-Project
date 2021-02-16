package com.eric.test;

import com.eric.mapper.UserMapper;
import com.eric.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * @Date: 2020/7/21 16:29
 * @author: Eric
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-dao.xml")
public class ManagerTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setName("Eric");
        user.setGender("男");
        user.setBirth("2020-12-22");
        this.userMapper.insertUser(user);
    }
}
