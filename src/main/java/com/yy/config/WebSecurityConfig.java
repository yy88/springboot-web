package com.yy.config;

import com.yy.interceptor.SecurityInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: yuanyuan.jing
 * @date: 2018/11/20 11:31
 * @description:
 */
@Configuration
public class WebSecurityConfig implements WebMvcConfigurer{
    @Bean
    public SecurityInterceptor getSecurityInterceptor() {
        return new SecurityInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());
        // 排除配置
        addInterceptor.excludePathPatterns("/");
        addInterceptor.excludePathPatterns("/login");
        addInterceptor.excludePathPatterns("/css/**");
        addInterceptor.excludePathPatterns("/js/**");
        addInterceptor.excludePathPatterns("/fonts/**");
        addInterceptor.excludePathPatterns("/img/**");
        // 拦截配置
        addInterceptor.addPathPatterns("/**");
    }
}
