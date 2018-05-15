package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by linziyu on 2018/5/13.
 * 视图跳转配置类
 *
 */

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //设置登录处理操作
        registry.addViewController("/login").setViewName("login");
    }
}
