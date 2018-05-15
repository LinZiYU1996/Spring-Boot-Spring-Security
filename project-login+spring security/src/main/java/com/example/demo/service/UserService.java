package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.data.domain.Page;

/**
 * Created by linziyu on 2018/5/13.
 * 用户类Service
 *
 */
public interface UserService {
    void save(User user);//保存用户
    Page<User> PageByUser(Integer page,Integer size);//对用户数据进行分页

}
