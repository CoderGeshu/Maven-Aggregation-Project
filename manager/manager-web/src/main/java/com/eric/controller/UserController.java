package com.eric.controller;

import com.eric.pojo.User;
import com.eric.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Date: 2020/12/22 10:52
 * @author: Eric
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/addUser")
    public String addUser(User user) {
        this.userService.addUser(user);
        return "success";
    }
}
