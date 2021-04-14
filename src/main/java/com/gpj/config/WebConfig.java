package com.gpj.config;

import com.gpj.interceptor.LoginInterceptor;
import com.gpj.interceptor.LoginInterceptor2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;
    @Autowired
    private LoginInterceptor2 loginInterceptor2;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截
        registry.addInterceptor(loginInterceptor).addPathPatterns("/admin/**","/doctor/**");
        registry.addInterceptor(loginInterceptor2).addPathPatterns("/admin/**","/patient/**");
    }
}
