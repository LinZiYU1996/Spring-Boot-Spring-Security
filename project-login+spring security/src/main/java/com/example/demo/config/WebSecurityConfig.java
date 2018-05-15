package com.example.demo.config;

import com.example.demo.service.SecurityService;
import com.example.demo.util.MD5Util;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by linziyu on 2018/5/13.
 * 安全配置类
 *
 */

@Configuration//指定为配置类
@EnableWebSecurity//指定为Spring Security配置类
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Bean
    UserDetailsService Service(){
        return new SecurityService();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(Service()).passwordEncoder(new PasswordEncoder() {

                //用户加密配置
                @Override
                public String encode(CharSequence charSequence) {
                    return MD5Util.encode((String)charSequence);
                }

                @Override
                public boolean matches(CharSequence charSequence, String s) {
                    return s.equals(MD5Util.encode((String)charSequence));
                }
            });
    }

    /*
    通过 authorizeRequests() 定义哪些URL需要被保护、哪些不需要被保护
    通过 formLogin() 定义当需要用户登录时候，转到的登录页面。
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().
                //设置静态资源均可以访问
                antMatchers("/css/**", "/js/**","/images/**", "/webjars/**", "**/favicon.ico", "/index").permitAll()
                .anyRequest().authenticated().
                and().
                //指定登录认证的Controller
                formLogin().loginPage("/login").permitAll().
                and().
                logout().permitAll();
    }
}
