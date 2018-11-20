package com.yy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author: yuanyuan.jing
 * @date: 2018/11/16 16:50
 * @description:
 */
@Controller
@Slf4j
public class HelloController {

    @RequestMapping("/")
    public String login(){
        log.info("login.html");
        return "login.html";
    }

    @RequestMapping("/index")
    public String index(){
        log.info("index.html");
        return "index.html";
    }

}
