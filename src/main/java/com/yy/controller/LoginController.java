package com.yy.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: yuanyuan.jing
 * @date: 2018/11/20 11:47
 * @description: 用户登录
 */
@RestController
@Slf4j
@Data
@ConfigurationProperties(prefix = "myconfig")
public class LoginController {
    private Map<String,String> users=new HashMap<>();
    /**
     * 登录session key
     */
    public final static String SESSION_KEY = "user";
    @PostMapping("/login")
    public boolean login(String username, String password, HttpServletRequest request, HttpServletResponse response){
        try {
            if (users.containsKey(username)&&users.get(username).equals(password)){
                request.getSession().setAttribute(SESSION_KEY,username);
                return true;
            }
        } catch (Exception e) {
            log.info("登录发生异常：{}",e.getMessage());
        }
        log.info("认证失败：用户名：{},密码：{}",username,password);
        return false;
    }
}
