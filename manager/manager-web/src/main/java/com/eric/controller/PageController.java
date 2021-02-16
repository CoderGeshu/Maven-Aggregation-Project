package com.eric.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 跳转页面
 *
 * @Date: 2020/12/22 10:50
 * @author: Eric
 */
@Controller
public class PageController {

    @RequestMapping("/{page}")
    public String showPage(@PathVariable("page") String page) {
        return page;
    }
}
