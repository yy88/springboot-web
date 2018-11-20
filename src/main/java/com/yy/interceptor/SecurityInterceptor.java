package com.yy.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author: yuanyuan.jing
 * @date: 2018/11/20 11:36
 * @description:
 */
@Slf4j
public class SecurityInterceptor extends HandlerInterceptorAdapter {
    /**
     * 登录session key
     */
    public final static String SESSION_KEY = "user";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if (session.getAttribute(SESSION_KEY) != null){
            return true;
        }
        log.warn("用户未登录拦截，ip:{},拦截url：{}",request.getRemoteAddr(),request.getRequestURI());
        // 跳转登录
        String url = "/";
        response.sendRedirect(url);
        return false;
    }
}
